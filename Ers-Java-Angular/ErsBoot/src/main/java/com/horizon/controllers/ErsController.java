package com.horizon.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horizon.dtos.ReimbCreationDto;
import com.horizon.dtos.ReimbursementDto;
import com.horizon.models.ErsReimbursement;
import com.horizon.services.ErsService;

@RestController
@RequestMapping("/reimbursement")
@CrossOrigin(origins = "*")
public class ErsController {

	@Autowired
	private ErsService ers;

	@GetMapping
	public List<ReimbursementDto> getReimbursements(@RequestParam(name = "status", required = false)String status, @RequestParam(name = "authId", required = false) String filerId){
		if(status != null) {
			return ers.findByStatus(status);
		}
		if(filerId != null) {
			return ers.findByAuthId(Integer.parseInt(filerId));
		}
		return ers.getAllReimbursement();
	}
	
	@GetMapping("/{reimbId}")
	public ResponseEntity<ReimbursementDto> getReimbursementById(@PathVariable("reimbId") int id){
		ReimbursementDto reimb = ers.findById(id);
		return reimb !=null ? 
			new ResponseEntity<>(reimb, HttpStatus.OK): 
			new ResponseEntity<>(reimb, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	public ResponseEntity<String> registerReimbursementClaim(
			@Valid @RequestBody ReimbCreationDto newClaim) {
		ErsReimbursement newReimb = ers.add(newClaim); 
		return new ResponseEntity<>(newReimb.getReimbId() + " was created.", HttpStatus.CREATED);
	}
	
	@PatchMapping("/{reimbId}")
	public ResponseEntity<String> updateReimbursementClaim(
			@PathVariable(name = "reimbId") int id,
			@Valid @RequestBody ReimbCreationDto reviewedClaim) {
		ErsReimbursement reviewedReimb = ers.update(reviewedClaim); 
		return new ResponseEntity<>(reviewedReimb.getReimbId() + " was updated.", HttpStatus.CREATED);
	}
	

}
