package com.ssd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.project.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
