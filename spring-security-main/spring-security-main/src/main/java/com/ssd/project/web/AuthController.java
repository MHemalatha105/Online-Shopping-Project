package com.ssd.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.project.payload.LogInDto;
import com.ssd.project.payload.RegisterDto;
import com.ssd.project.repository.UserRepository;
import com.ssd.project.serviceImpl.AuthServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
	@Autowired
	public UserRepository userRepository;

	@Autowired
	public AuthServiceImpl authServiceImpl;

	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody RegisterDto registerDto) {

		if (userRepository.existsByUsername(registerDto.getUsername())) {
			return new ResponseEntity<String>("userName Already existed", HttpStatus.BAD_REQUEST);
		} else if (userRepository.existsByEmail(registerDto.getEmail())) {

			return new ResponseEntity<String>("Email Already existed", HttpStatus.BAD_REQUEST);
		} else {

			RegisterDto dto = authServiceImpl.saveUser(registerDto);
			return new ResponseEntity<RegisterDto>(dto, HttpStatus.CREATED);
		}

	}

	@PostMapping("/signin")
	public ResponseEntity<String> sainInUser(@RequestBody LogInDto logInDto) {

		String result = authServiceImpl.login(logInDto);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
