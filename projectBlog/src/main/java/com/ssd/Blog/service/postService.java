package com.ssd.Blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.Blog.Entity.PostEntity;
import com.ssd.Blog.exceptions.TitleExceptions;
import com.ssd.Blog.payload.PostDto;
import com.ssd.Blog.repository.PostRepository;

@Service
public class postService {
	
	@Autowired
	public PostRepository postRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	public PostDto makePost(PostDto Dto) {
		
		PostEntity post = this.modelMapper.map(Dto, PostEntity.class);
		try {
			 post  =	postRepository.save(post);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new TitleExceptions(Dto.getTittle(),Dto.getTittle()+"    The Title Your Provided IS AllReady Exits");
		}
		
		Dto = this.modelMapper.map(post, PostDto.class);
		return Dto;
	}

}
