package com.horizon.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.horizon.dtos.Mapper;
import com.horizon.dtos.ReimbCreationDto;
import com.horizon.dtos.ReimbursementDto;
import com.horizon.models.ErsReimbursement;
import com.horizon.repository.ErsReimbursementRepository;
import com.horizon.repository.ErsReimbursementStatusRepository;
import com.horizon.repository.ErsReimbursementTypeRepository;

@Service
@Transactional
public class ErsService {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private ErsReimbursementRepository err;
	
	@Autowired
	private ErsUserService eus;

	@Autowired
	private ErsReimbursementTypeRepository ertr;
	
	@Autowired
	private ErsReimbursementStatusRepository ersr;
	
	public List<ReimbursementDto> getAllReimbursement(){
		return err.findAll()
				.stream()
				.map(mapper::reimbToDto)
				.collect(Collectors.toList());
	}

	public List<ReimbursementDto> findByStatus(String status){
		return err.findByStatus(status)
				.stream()
				.map(mapper::reimbToDto)
				.collect(Collectors.toList());
	}

	public ReimbursementDto findById(int reimbId){
		return mapper.reimbToDto(err.findById(reimbId).orElse(null));
	}

	public List<ReimbursementDto> findByAuthId(int authId){
		return err.findByAuthorId(authId)
			.stream()
			.map(mapper::reimbToDto)
			.collect(Collectors.toList());
	}
	
	public ErsReimbursement add(ReimbCreationDto reimbDto){
		ErsReimbursement reimb = new ErsReimbursement();
		
		reimb.setReimbAmount(reimbDto.getReimbAmount());
		reimb.setReimbSubmitted(LocalDate.now());
		reimb.setReimbDescription(reimbDto.getReimbDescription());
		reimb.setReimbReceipt(reimbDto.getReimbReceipt());
		reimb.setReimbResolved(null);
		reimb.setReimbResolver(null);
		reimb.setReimbAuthor(eus.getErsUserById(reimbDto.getReimbAuthor()));
		reimb.setReimbStatus(ersr.getById(1));
		reimb.setReimbType(ertr.getById(reimbDto.getReimbType()));
		
		return err.save(reimb);
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public ErsReimbursement update(ReimbCreationDto reimbDto){
		ErsReimbursement reimb = err.getById(reimbDto.getReimbId());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		reimb.setReimbAmount(reimbDto.getReimbAmount());
		reimb.setReimbSubmitted(LocalDate.parse(reimbDto.getReimbSubmitted(), formatter));
		reimb.setReimbDescription(reimbDto.getReimbDescription());
		reimb.setReimbReceipt(reimbDto.getReimbReceipt());
		reimb.setReimbResolved(LocalDate.parse(reimbDto.getReimbResolved()));
		if(reimbDto.getReimbResolver() == 0) {
			reimb.setReimbResolver(null);
		}else {
			reimb.setReimbResolver(eus.getErsUserById(reimbDto.getReimbResolver()));
		}
		reimb.setReimbAuthor(eus.getErsUserById(reimbDto.getReimbAuthor()));
		reimb.setReimbStatus(ersr.getById(reimbDto.getReimbStatus()));
		reimb.setReimbType(ertr.getById(reimbDto.getReimbType()));
		return err.save(reimb);
	}
}
