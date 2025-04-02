package com.RestTempletProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestTempletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestTempletApplication.class, args);
	}
	

	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

}
