package com.ssd.Blog.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.Blog.payload.PostDto;
import com.ssd.Blog.service.ErrorMsgService;
import com.ssd.Blog.service.postService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Main")
public class PostController {
	
	@Autowired
	public postService postService;
	
	@Autowired
	public ErrorMsgService errorMsgService;
	
	@PostMapping("/Posts")
	public ResponseEntity<?> makePost(@Valid @RequestBody PostDto postDto,BindingResult errorresult){

		if(errorresult.hasErrors()) {
			return errorMsgService.getBindingErrors(errorresult);
		}else {
			return new ResponseEntity<PostDto> ( postService.makePost(postDto),HttpStatus.CREATED);
		}


		
		
		
	}

}
