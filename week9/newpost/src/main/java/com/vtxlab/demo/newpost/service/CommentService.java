package com.vtxlab.demo.newpost.service;

import java.util.Optional;

import com.vtxlab.demo.newpost.entity.Comment;

public interface CommentService {
  
  public Optional<Comment> findByPostId(Long id);
}
