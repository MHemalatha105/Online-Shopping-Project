package com.RestTempletProject.exception;

public class EmployeeAlredyExisted extends RuntimeException {

	public EmployeeAlredyExisted(String errorMsg) {
		super(errorMsg);
		
	}

}
