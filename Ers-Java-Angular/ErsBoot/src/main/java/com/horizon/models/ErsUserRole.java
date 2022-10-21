package com.horizon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
//@JsonIdentityInfo(
//	generator = ObjectIdGenerators.PropertyGenerator.class,
//	property = "ersUserRoleId")
@Entity
@Table(name="ers_users_role")
@Data
public class ErsUserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ersUserRoleId;
	private String ersUserRole;
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="userRoleId")
//	private List<ErsUser> ersUser;
	
}
