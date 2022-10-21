package com.horizon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ers_users")
@Getter
@Setter
//@JsonIdentityInfo(
//	generator = ObjectIdGenerators.PropertyGenerator.class,
//	property = "ersUserId")
public class ErsUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ersUserId;
	@Column(nullable=false, unique=true)
	private String ersUsername;
	@Column(nullable=false)
	private String ersPassword;
	private String userFirstName;
	private String userLastName;
	@Column(nullable=false, unique=true)
	private String userEmail;

//	@OneToMany (cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="reimbAuthor")
//	private List<ErsReimbursement> ersReimbursements;
//		
//	@OneToMany (cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="reimbResolver")
//	private List<ErsReimbursement> reimbsResolved;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role_id")
	private ErsUserRole userRoleId;
}