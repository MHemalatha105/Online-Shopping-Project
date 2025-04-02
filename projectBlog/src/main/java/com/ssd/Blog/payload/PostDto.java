package com.ssd.Blog.payload;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto {
	
	public Integer id;
	
	@NotEmpty(message = "Please Enter Title")
	@Size(min = 4 ,max = 20)
	public String tittle;
	
	@NotEmpty(message = "Please Enter Content")
	public String Content;
	
	@NotEmpty(message = "Please Enter discription")
	public String discription;
	public Date postDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public PostDto(Integer id, String tittle, String content, String discription, Date postDate) {
		super();
		this.id = id;
		this.tittle = tittle;
		Content = content;
		this.discription = discription;
		this.postDate = postDate;
	}
	public PostDto(String tittle, String content, String discription, Date postDate) {
		super();
		this.tittle = tittle;
		Content = content;
		this.discription = discription;
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", tittle=" + tittle + ", Content=" + Content + ", discription=" + discription
				+ ", postDate=" + postDate + "]";
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
