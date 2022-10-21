package com.horizon.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "reimbId")
@Entity
@Table(name="ers_reimbursement")
@Data
public class ErsReimbursement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbId;
	private double reimbAmount;
	@Column(name = "reimb_submitted", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate reimbSubmitted;

	@Column(name = "reimb_resolved", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private LocalDate reimbResolved;
	private String reimbDescription;
//	@Lob
	private String reimbReceipt; //This is a blob
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimb_author")
	private ErsUser reimbAuthor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimb_resolver")
	private ErsUser reimbResolver = null;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimb_status")
	private ErsReimbursementStatus reimbStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimb_type")
	private ErsReimbursementType reimbType;
		
}
