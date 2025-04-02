package com.ssd.project.serviceImpl;

import java.util.Collections;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssd.project.entity.Role;
import com.ssd.project.entity.User;
import com.ssd.project.payload.LogInDto;
import com.ssd.project.payload.RegisterDto;
import com.ssd.project.repository.RoleRepository;
import com.ssd.project.repository.UserRepository;
import com.ssd.project.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	public UserRepository userRepository;
	@Autowired
	public RoleRepository roleRepository;
	@Autowired
	public ModelMapper mapper;
	@Autowired
	public PasswordEncoder encoder;
	@Autowired
	public AuthenticationManager authenticationManager;

	@Override
	public RegisterDto saveUser(RegisterDto registerDto) {

//		registerDto.setPassword(encoder.encode(registerDto.getPassword()));
//		User user = mapper.map(registerDto, User.class);
//		Role role = roleRepository.findByName("ROLE_ADMIN").orElseThrow(() -> new NoSuchElementException());
//		user.setRoles(Collections.singleton(role));
//		user = userRepository.save(user);
//		registerDto = mapper.map(user, RegisterDto.class);

		User user = new User();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(encoder.encode(registerDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new NoSuchElementException());
		user.setRoles(Collections.singleton(role));
		user = userRepository.save(user);
		registerDto = mapper.map(user, RegisterDto.class);

		return registerDto;
	}

	public String login(LogInDto logInDto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(logInDto.getUserNameOrEmail(),logInDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "userLogin success";
	}

}
