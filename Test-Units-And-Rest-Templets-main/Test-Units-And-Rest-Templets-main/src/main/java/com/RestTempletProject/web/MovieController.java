package com.RestTempletProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestTempletProject.entity.Root;
import com.RestTempletProject.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	@Autowired
	public MovieService movieService;

	@GetMapping("/movies")
	public ResponseEntity<Root> findAllMovies() {
		Root moviess = movieService.findByAllMovies();
		return new ResponseEntity<Root>(moviess, HttpStatus.OK);
	}

}
