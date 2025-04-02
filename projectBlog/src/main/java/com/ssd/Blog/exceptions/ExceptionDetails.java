package com.ssd.Blog.exceptions;

import java.util.Date;

public class ExceptionDetails {
	
	public Date timeStamp;
	public String field;
	public String meassage;
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	public ExceptionDetails(Date timeStamp, String field, String meassage) {
		super();
		this.timeStamp = timeStamp;
		this.field = field;
		this.meassage = meassage;
	}
	public ExceptionDetails() {
		super();
	}
	@Override
	public String toString() {
		return "ExceptionDetails [timeStamp=" + timeStamp + ", field=" + field + ", meassage=" + meassage + "]";
	}
	
	

}
