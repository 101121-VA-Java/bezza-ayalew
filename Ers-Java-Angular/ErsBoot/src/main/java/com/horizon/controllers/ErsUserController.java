package com.horizon.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horizon.dtos.Mapper;
import com.horizon.dtos.UserDto;
import com.horizon.models.ErsUser;
import com.horizon.services.ErsUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class ErsUserController {
	
	@Autowired
	private ErsUserService eus;
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<UserDto> get(){
		return eus.getErsUsers();
	}

	@GetMapping("/{ersUserId}")
	public UserDto getUserById(@PathVariable(name="ersUserId") int id){
		return mapper.userToDto(eus.getErsUserById(id));
	}
	
//	@PutMapping("/{ersUserId}")
//	public ResponseEntity<ErsUser> updateErsUserInfo(
//			@PathVariable(name = "ersUserId") int id,
//			@Valid @RequestBody ErsUser newUserDetails){
//		ErsUser updatedUser = eus.updateErsUserInfo(newUserDetails);
//		return new ResponseEntity<ErsUser>(updatedUser, HttpStatus.OK);
//	}
	@PatchMapping("/{ersUserId}")
	public ResponseEntity<ErsUser> partiallyUpdateErsUserInfo(
			@PathVariable(name = "ersUserId") int id, 
			@Valid @RequestBody ErsUser newUserDetails) {
		ErsUser updatedUser = eus.updateErsUserInfo(newUserDetails);
		return new ResponseEntity<ErsUser>(updatedUser, HttpStatus.OK);
	}
}
