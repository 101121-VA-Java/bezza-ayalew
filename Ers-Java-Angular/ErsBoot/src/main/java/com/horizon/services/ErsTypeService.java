package com.horizon.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.horizon.models.ErsReimbursementType;
import com.horizon.repository.ErsReimbursementTypeRepository;

public class ErsTypeService {

	@Autowired
	ErsReimbursementTypeRepository ert;
	
	public ErsReimbursementType getErsUserById(int id){
		ErsReimbursementType ersType = ert.findById(id).orElse(null);
		return ersType;
	}
}
