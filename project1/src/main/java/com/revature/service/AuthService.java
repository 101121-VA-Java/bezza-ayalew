package com.revature.service;

import java.io.IOException;

import com.revature.dao.ErsUsersPostgres;
import com.revature.model.ErsUsers;

public class AuthService {

	ErsUsersPostgres eup = new ErsUsersPostgres();
	/**
	 * Service method to login an employee based on username/password
	 * @param String username, String password
	 * @return String token if credentials are valid, null otherwise
	 * @throws IOException 
	 */
	public String login(String username, String password) throws IOException {
		
		String token = null;
		ErsUsers principal = eup.getErsUserByUsername(username);

		if (principal != null && principal.getErsPassword().equals(password)) {
			token = principal.getErsUserId() + ":" + principal.getUserRoleId();
		}

		return token;
	}
	
	/**
	 * Service method to check the permission of the user to access certain functionalities
	 * @param String token
	 * @return true if a user is authenticated and has permission, false otherwise
	 * @throws IOException 
	 */
	public boolean checkPermission(String token) throws IOException {

		if(token == null) {
			return false;
		}
		
		String[] info = token.split(":"); 
		int token_id = Integer.parseInt(info[0]);
		int token_role = Integer.parseInt(info[1]);
		
		ErsUsers principal = eup.getErsUserById(token_id);
		
		if(principal != null && token_role == principal.getUserRoleId()
				&& token_role == 2) {
			return true;
		}
		
		return false;
	}
}
