package com.horizon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
//@JsonIdentityInfo(
//	generator = ObjectIdGenerators.PropertyGenerator.class,
//	property = "reimbTypeId")
@Entity
@Table(name="ers_reimbursement_type")
@Data
public class ErsReimbursementType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbTypeId;
	private String reimbType;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reimbType")
//	private List<ErsReimbursement> ersReimbursement;
}
