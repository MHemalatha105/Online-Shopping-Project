package com.ssd.project.service;

import com.ssd.project.payload.RegisterDto;

public interface AuthService {

	public RegisterDto saveUser(RegisterDto registerDto);

}
