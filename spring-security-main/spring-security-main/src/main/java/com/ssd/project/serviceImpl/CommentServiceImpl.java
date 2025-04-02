package com.ssd.project.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.project.entity.Comment;
import com.ssd.project.entity.Post;
import com.ssd.project.payload.CommentDto;
import com.ssd.project.repository.CommentRepository;
import com.ssd.project.repository.PostRepository;
import com.ssd.project.service.CommentServiceInterFace;

@Service
public class CommentServiceImpl implements CommentServiceInterFace {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentDto createComment(Long id, CommentDto commentDto) {

		Comment com = mapper.map(commentDto, Comment.class);

		Post post = postRepository.findById(id).get();
		com.setPost(post);

		com = commentRepository.save(com);
		commentDto = mapper.map(com, CommentDto.class);

		return commentDto;
	}

	

}
