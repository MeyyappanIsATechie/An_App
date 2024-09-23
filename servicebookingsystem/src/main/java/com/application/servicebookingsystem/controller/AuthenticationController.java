package com.application.servicebookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.servicebookingsystem.dto.SignUpRequestDTO;
import com.application.servicebookingsystem.dto.UserDto;
import com.application.servicebookingsystem.services.authentication.AuthService;

@RestController
public class AuthenticationController {
@Autowired
private AuthService authService;

@PostMapping("/client/sign-up")
public ResponseEntity<?> signupClient(@RequestBody SignUpRequestDTO signUpRequestDTO){
	if(authService.presentByEmail(signUpRequestDTO.getEmail())) {
		return new ResponseEntity<>("Client already exists",HttpStatus.NOT_ACCEPTABLE);
	}
	UserDto createdUserDto = authService.signupClient(signUpRequestDTO);
	
	return new ResponseEntity<>(createdUserDto,HttpStatus.OK);
}

@PostMapping("/company/sign-up")
public ResponseEntity<?> signupCompany(@RequestBody SignUpRequestDTO signUpRequestDTO){
	if(authService.presentByEmail(signUpRequestDTO.getEmail())) {
		return new ResponseEntity<>("Company already exists",HttpStatus.NOT_ACCEPTABLE);
	}
	UserDto createdUserDto = authService.signupClient(signUpRequestDTO);
	
	return new ResponseEntity<>(createdUserDto,HttpStatus.OK);
}
}
