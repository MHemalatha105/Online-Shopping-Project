package com.ssd.project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

	
	public static void main(String[] args) {
		PasswordEncoder hh = new BCryptPasswordEncoder();
		System.out.println(hh.encode("hari"));
	
	}
}
