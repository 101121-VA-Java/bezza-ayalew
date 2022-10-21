package com.horizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horizon.dtos.UserDto;
import com.horizon.models.ErsUser;
import com.horizon.services.ErsUserService;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private ErsUserService ers;
	
	@PostMapping
	public ResponseEntity<UserDto> login(@RequestBody ErsUser user){
		UserDto u = ers.login(user);
		if(u != null) {
			String token = u.getErsUserId() + ":" + u.getErsUserRole();
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", token);
			return new ResponseEntity<>(u, headers, HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}
