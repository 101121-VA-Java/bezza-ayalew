package com.horizon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizon.models.ErsUser; 

@Repository
public interface ErsUserRepository extends JpaRepository<ErsUser, Integer>{

	ErsUser findByErsUsername(String username);
		
}


