package com.horizon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.horizon.models.ErsReimbursementStatus;

public interface ErsReimbursementStatusRepository extends JpaRepository<ErsReimbursementStatus, Integer>{
//	@Query("select e from ersReimbursementStatus e where e.reimbStatus.reimbStatus =:status")	
//	List<ErsReimbursement> findByStatus(String status);
}
