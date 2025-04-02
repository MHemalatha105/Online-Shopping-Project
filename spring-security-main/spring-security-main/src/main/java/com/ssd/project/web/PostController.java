package com.ssd.project.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.project.payload.PostDto;
import com.ssd.project.serviceImpl.PostServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;

//	@GetMapping("/display")
//	public String display() {
//		return "hello world";
//	}

	@PostMapping("/post")
	public ResponseEntity<?> createPost(@Validated @RequestBody PostDto postDto, BindingResult result) {

		Map<String, String> errorMap = new HashMap<>();
		if (result.hasErrors()) {
			for (FieldError fe : result.getFieldErrors()) {

				errorMap.put(fe.getField(), fe.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		} else {
			postDto = postServiceImpl.createPost(postDto);
			return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
		}
	}

	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> getAllPosts() {

		List<PostDto> dtoList = postServiceImpl.getAllPosts();

		return new ResponseEntity<List<PostDto>>(dtoList, HttpStatus.OK);

	}

	@GetMapping("/post/{id}")
	public ResponseEntity<PostDto> getByid(@PathVariable Long id) {

		PostDto dto = postServiceImpl.getPostByid(id);

		return new ResponseEntity<PostDto>(dto, HttpStatus.OK);

	}

}
