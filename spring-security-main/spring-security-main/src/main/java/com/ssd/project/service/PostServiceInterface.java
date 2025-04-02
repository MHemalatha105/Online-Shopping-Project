package com.ssd.project.service;

import java.util.List;

import com.ssd.project.payload.PostDto;

public interface PostServiceInterface {

	public PostDto createPost(PostDto dto);
	
	public List<PostDto>getAllPosts();

	public PostDto getPostByid(Long id);
	
	
}
