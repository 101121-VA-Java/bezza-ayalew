package com.horizon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@JsonIdentityInfo(
//	generator = ObjectIdGenerators.PropertyGenerator.class,
//	property = "reimbStatusId")
@Entity
@Table(name="ers_reimbursement_status")
@Data
public class ErsReimbursementStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbStatusId;
	private String reimbStatus;
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reimbStatus")
//	private List<ErsReimbursement> ersReimbursement;
	
}
