package com.application.servicebookingsystem.services.authentication;

import com.application.servicebookingsystem.dto.SignUpRequestDTO;
import com.application.servicebookingsystem.dto.UserDto;

public interface AuthService {
	UserDto signupClient(SignUpRequestDTO signUpRequestDTO);
	Boolean presentByEmail(String email);
}
