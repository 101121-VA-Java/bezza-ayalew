package com.horizon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizon.models.ErsReimbursement;

@Repository
public interface ErsReimbursementRepository extends JpaRepository<ErsReimbursement, Integer> {

	@Query("select s from ErsReimbursement s where s.reimbStatus.reimbStatus =:status")	
	List<ErsReimbursement> findByStatus(String status);
	
	@Query("select e from ErsReimbursement e where e.reimbAuthor.ersUserId =:authId")	
	List<ErsReimbursement> findByAuthorId(int authId);

}
