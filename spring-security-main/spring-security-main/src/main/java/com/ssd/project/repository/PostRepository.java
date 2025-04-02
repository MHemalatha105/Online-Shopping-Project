package com.ssd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.project.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
