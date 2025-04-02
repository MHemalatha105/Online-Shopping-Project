package com.ssd.Blog.web;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ssd.Blog.exceptions.ExceptionDetails;
import com.ssd.Blog.exceptions.TitleExceptions;


@ControllerAdvice
public class ProjectBlogExceptionController {

	
	@ExceptionHandler(value=TitleExceptions.class)
	public ResponseEntity<ExceptionDetails> excep(TitleExceptions titleExceptions){
		
		ExceptionDetails exepDe=new ExceptionDetails(new Date(),titleExceptions.getTitle(),titleExceptions.getExpMsg());
		
		return new ResponseEntity<ExceptionDetails>(exepDe,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
