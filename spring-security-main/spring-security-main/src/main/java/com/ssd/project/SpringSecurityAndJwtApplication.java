package com.ssd.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityAndJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAndJwtApplication.class, args);
		System.out.println("heloo world");
	}

	@Bean
	public ModelMapper mapper() {

		return new ModelMapper();
	}

}
