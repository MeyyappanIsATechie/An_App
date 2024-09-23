package com.application.servicebookingsystem.services.authentication;

import org.springframework.stereotype.Service;

import com.application.servicebookingsystem.dto.SignUpRequestDTO;
import com.application.servicebookingsystem.dto.UserDto;

@Service
public interface AuthService {
	UserDto signupClient(SignUpRequestDTO signUpRequestDTO);
	Boolean presentByEmail(String email);
	UserDto signupCompany(SignUpRequestDTO signUpRequestDTO);
}
