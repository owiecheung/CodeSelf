package com.vtxlab.demo.newpost.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.newpost.entity.Comment;
import com.vtxlab.demo.newpost.repository.CommentRepository;
import com.vtxlab.demo.newpost.service.CommentService;


@Service
public class LihkgCommentService  implements CommentService{
  

  @Autowired
  CommentRepository commentRepository;
  
  @Override
  public Optional<Comment> findByPostId(Long id){
    return commentRepository.findById(id);
  }


}
