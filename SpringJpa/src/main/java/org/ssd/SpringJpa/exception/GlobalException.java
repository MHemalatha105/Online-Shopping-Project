package org.ssd.SpringJpa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalException {

	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<Object> ExceptionHandler(PaymentException exceptionHandler){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(),exceptionHandler.getMessage(),exceptionHandler.getField());
		
		return new ResponseEntity<Object>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}
