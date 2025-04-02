package org.ssd.SpringJpa.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String field;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.field = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return field;
    }

    public String getDetails() {
        return details;
    }

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
