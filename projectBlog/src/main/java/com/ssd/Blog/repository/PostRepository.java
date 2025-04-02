package com.ssd.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.Blog.Entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
