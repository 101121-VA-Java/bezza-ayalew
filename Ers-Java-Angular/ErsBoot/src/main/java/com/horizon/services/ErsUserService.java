package com.horizon.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.horizon.dtos.Mapper;
import com.horizon.dtos.UserDto;
import com.horizon.models.ErsUser;
import com.horizon.repository.ErsUserRepository;
import com.horizon.exceptions.UserNotFoundException;

@Service
public class ErsUserService {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired	
	private ErsUserRepository euRepo;

	public List<UserDto> getErsUsers(){
		return euRepo.findAll()
			.stream()
			.map(mapper::userToDto)
			.collect(Collectors.toList());
	}

	public ErsUser getErsUserById(int id){
		return euRepo.getById(id);
	}

	public UserDto getErsUserByUsername(String username){
		return mapper.userToDto(euRepo.findByErsUsername(username));
	}
	
	public UserDto login(ErsUser user) {
		ErsUser u = euRepo.findByErsUsername(user.getErsUsername());
		UserDto userDto = mapper.userToDto(u);
		if(u.getErsPassword().equals(user.getErsPassword())) {
			return userDto;
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public ErsUser updateErsUserInfo(ErsUser ersUser) throws UserNotFoundException {
		
		ErsUser ersUser_update = euRepo.getById(ersUser.getErsUserId());
		
		if(ersUser_update == null) {
			throw new UserNotFoundException();
			}
		
		if(ersUser.getUserFirstName() != null) {
			ersUser_update.setUserFirstName(ersUser.getUserFirstName());
		}
		
		if(ersUser.getUserLastName() != null) {
			ersUser_update.setUserLastName(ersUser.getUserLastName());
		}
		
		if(ersUser.getErsUsername() != null) {
			ersUser_update.setErsUsername(ersUser.getErsUsername());
		}

		if(ersUser.getErsPassword() != null) {
			ersUser_update.setErsPassword(ersUser.getErsPassword());
		}
		
		return euRepo.save(ersUser_update);	
	}

}

