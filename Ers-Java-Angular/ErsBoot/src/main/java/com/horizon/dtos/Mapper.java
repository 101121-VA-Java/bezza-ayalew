package com.horizon.dtos;

import java.text.ParseException;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.horizon.models.ErsReimbursement;
import com.horizon.models.ErsUser;
import com.horizon.repository.ErsReimbursementStatusRepository;
import com.horizon.repository.ErsReimbursementTypeRepository;
import com.horizon.repository.ErsUserRepository;

@Component
public class Mapper {
	
	@Autowired
	private ErsUserRepository eur;
	@Autowired
	private ErsReimbursementStatusRepository ersr;
	@Autowired
	private ErsReimbursementTypeRepository ertr;
	
    public UserDto userToDto(ErsUser user) {
    	UserDto u = new UserDto();
    	
    	u.setErsUserId(user.getErsUserId());
    	u.setErsPassword(null);
    	u.setErsUsername(user.getErsUsername());
    	u.setUserEmail(user.getUserEmail());
        u.setUserFirstName(user.getUserFirstName());
        u.setUserLastName(user.getUserLastName());
        u.setErsUserRole(user.getUserRoleId().getErsUserRoleId());

        return u;
    }

	public ErsUser toUser(UserCreationDto userDto) {
    	ErsUser createdUser = new ErsUser();
    	createdUser.getErsUserId();
    	createdUser.getErsUsername();
    	createdUser.getErsPassword();
    	createdUser.getUserEmail();
    	createdUser.getUserFirstName();
    	createdUser.getUserLastName();
    	createdUser.getUserRoleId();
        return createdUser;
    }
    
    public ErsReimbursement toReimbursement(ReimbCreationDto reimbDto) throws ParseException {
    	ErsReimbursement createdReimb = new ErsReimbursement();
    	createdReimb.setReimbId(reimbDto.getReimbId());
    	createdReimb.setReimbAmount(reimbDto.getReimbAmount());
    	createdReimb.setReimbDescription(reimbDto.getReimbDescription());
    	createdReimb.setReimbReceipt(reimbDto.getReimbReceipt());
    	
    	LocalDate resolutionDate = null;
    	if(reimbDto.getReimbResolved() != "") {
    		resolutionDate = LocalDate.parse(reimbDto.getReimbResolved());
    	}
    	createdReimb.setReimbResolved(resolutionDate);
    	LocalDate submissionDate = LocalDate.now();
    	if(reimbDto.getReimbSubmitted() != "") {
    		submissionDate = LocalDate.parse(reimbDto.getReimbSubmitted());
    	}
    	createdReimb.setReimbSubmitted(submissionDate);
    	createdReimb.setReimbAuthor(eur.getById(reimbDto.getReimbAuthor()));
    	
    	if(reimbDto.getReimbResolver() != 0) {
    		createdReimb.setReimbResolver(eur.getById(reimbDto.getReimbResolver()));
    	}else {
    		createdReimb.setReimbResolver(null);
    	}
    	createdReimb.setReimbStatus(ersr.getById(reimbDto.getReimbStatus()));
    	createdReimb.setReimbType(ertr.getById(reimbDto.getReimbType()));
    	return createdReimb;
    }

    public ReimbursementDto reimbToDto(ErsReimbursement reimb) {
    	ReimbursementDto reducedReimb = new ReimbursementDto();
    	reducedReimb.setReimbId(reimb.getReimbId());
    	reducedReimb.setReimbAmount(reimb.getReimbAmount());
    	reducedReimb.setReimbDescription(reimb.getReimbDescription());
    	reducedReimb.setReimbReceipt(reimb.getReimbReceipt());
    	reducedReimb.setReimbResolved(reimb.getReimbResolved());
    	reducedReimb.setReimbSubmitted(reimb.getReimbSubmitted());
    	reducedReimb.setReimbAuthor(reimb.getReimbAuthor().getErsUserId());
    	if(reimb.getReimbResolver() != null) {
    		reducedReimb.setReimbResolver(reimb.getReimbResolver().getErsUserId());
    	}else {
    		reducedReimb.setReimbResolver(0);
    	}
    	reducedReimb.setReimbStatus(reimb.getReimbStatus().getReimbStatusId());
    	if(reimb.getReimbType() != null) {
    		reducedReimb.setReimbType(reimb.getReimbType().getReimbTypeId());
    	}else {
    		reducedReimb.setReimbType(0);
    	}
    	return reducedReimb;
    }
}
