package com.ssd.project.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.project.entity.Post;
import com.ssd.project.payload.PostDto;
import com.ssd.project.repository.PostRepository;
import com.ssd.project.service.PostServiceInterface;

@Service
public class PostServiceImpl implements PostServiceInterface {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public PostDto createPost(PostDto dto) {

		Post post = mapper.map(dto, Post.class);
		Date date = new Date();

		post.setPostDate(date);

		post = postRepository.save(post);

		dto = mapper.map(post, PostDto.class);

		return dto;
	}

	@Override
	public List<PostDto> getAllPosts() {

		List<Post> postList = postRepository.findAll();
		List<PostDto> dtoList = postList.stream().map(post -> mapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return dtoList;
	}

	@Override
	public PostDto getPostByid(Long id) {

		Post po = postRepository.findById(id).get();
		PostDto dto = mapper.map(po, PostDto.class);

		return dto;
	}

}
