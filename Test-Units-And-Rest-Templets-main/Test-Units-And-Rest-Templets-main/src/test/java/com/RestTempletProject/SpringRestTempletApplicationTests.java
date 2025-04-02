package com.RestTempletProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RestTempletProject.service.GradeCalculator;
import com.RestTempletProject.service.MovieService;

@SpringBootTest
class SpringRestTempletApplicationTests {

	@Autowired
	public GradeCalculator calculator;

	@Autowired
	public MovieService movieService;

	@Test
	void contextLoads() {
		movieService.findByAllMovies();

	}

	

}
