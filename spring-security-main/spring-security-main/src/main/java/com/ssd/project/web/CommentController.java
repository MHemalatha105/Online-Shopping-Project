package com.ssd.project.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.project.payload.CommentDto;
import com.ssd.project.serviceImpl.CommentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;

	
	
	@PostMapping("/post/{id}/comment")
	public ResponseEntity<?> createComment(@Valid  @PathVariable("id") Long Id ,@RequestBody CommentDto dto, BindingResult error) {

		Map<String, String> errorMap = new HashMap<>();

		if (error.hasErrors()) {
			for (FieldError fe : error.getFieldErrors()) {

				errorMap.put(fe.getField(), fe.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		} else {
			dto = commentServiceImpl.createComment(Id, dto);
			return new ResponseEntity<CommentDto>(dto, HttpStatus.CREATED);
		}

	}
	
	
	
	
	

}
