package com.horizon.dtos;

import lombok.Data;

@Data
public class UserDto {

	private int ersUserId;
	private String ersPassword;
	private String ersUsername;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private int ersUserRole;
}
