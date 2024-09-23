package com.application.servicebookingsystem.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.servicebookingsystem.dto.SignUpRequestDTO;
import com.application.servicebookingsystem.dto.UserDto;
import com.application.servicebookingsystem.entity.User;
import com.application.servicebookingsystem.enums.UserRole;
import com.application.servicebookingsystem.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
@Autowired
private UserRepository userRepository;

public UserDto signupClient(SignUpRequestDTO signUpRequestDTO) {
	User user = new User();
	user.setName(signUpRequestDTO.getName());
	user.setLastname(signUpRequestDTO.getLastname());
	user.setEmail(signUpRequestDTO.getEmail());
	user.setPhone(signUpRequestDTO.getPhone());
	user.setPassword(signUpRequestDTO.getPassword());
	user.setRole(UserRole.CLIENT);
	
	return userRepository.save(user).getDto();
}
public Boolean presentByEmail(String email) {
	return userRepository.findFirstByEmail(email)!=null;
}

public UserDto signupCompany(SignUpRequestDTO signUpRequestDTO) {
	User user = new User();
	user.setName(signUpRequestDTO.getName());
	user.setEmail(signUpRequestDTO.getEmail());
	user.setPhone(signUpRequestDTO.getPhone());
	user.setPassword(signUpRequestDTO.getPassword());
	user.setRole(UserRole.COMPANY);
	
	return userRepository.save(user).getDto();
}

}
