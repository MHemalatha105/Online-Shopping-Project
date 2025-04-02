package org.ssd.SpringJpa.exception;

public class PaymentException extends RuntimeException {
	public String message;
	public String field;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	
	public PaymentException(String message, String field) {
		super();
		this.message = message;
		this.field = field;
	
	}
	public PaymentException() {
		super();
	}
	
}
