package com.ssd.Blog.exceptions;

public class TitleExceptions extends RuntimeException {
	
	public String title;
	public String expMsg;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExpMsg() {
		return expMsg;
	}
	public void setExpMsg(String expMsg) {
		this.expMsg = expMsg;
	}
	public TitleExceptions(String title, String expMsg) {
		super();
		this.title = title;
		this.expMsg = expMsg;
	}
	@Override
	public String toString() {
		return "TitleExceptions [title=" + title + ", expMsg=" + expMsg + "]";
	}
	
	

}
