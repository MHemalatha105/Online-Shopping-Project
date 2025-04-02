package com.ssd.Blog.Entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@Column(unique = true)
	public String tittle;
	public String Content;
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
	public PostEntity(Integer id, String tittle, String content, String discription, Date postDate) {
		super();
		this.id = id;
		this.tittle = tittle;
		Content = content;
		this.discription = discription;
		this.postDate = postDate;
	}
	public PostEntity(String tittle, String content, String discription, Date postDate) {
		super();
		this.tittle = tittle;
		Content = content;
		this.discription = discription;
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "PostEntity [id=" + id + ", tittle=" + tittle + ", Content=" + Content + ", discription=" + discription
				+ ", postDate=" + postDate + "]";
	}
	public PostEntity() {
		super();
	}
	
	
}
