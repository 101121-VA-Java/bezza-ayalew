package com.horizon.dtos;

import lombok.Data;

@Data
public class UserCreationDto {

	private String ersPassword;
	private String ersUsername;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private int userRoleId;
}
