package com.vtxlab.demo.newpost.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.newpost.entity.NewPost;
import com.vtxlab.demo.newpost.repository.NewPostRepository;
import com.vtxlab.demo.newpost.service.NewPostService;


@Service
public class LihkgNewPostService implements NewPostService {
  
  @Autowired
  NewPostRepository newPostRepository;

  @Override
  public List<NewPost> findAllPost(){
    return newPostRepository.findAll();
  }


  @Override
  public Optional<NewPost> findPostById(Long id){
    return newPostRepository.findById(id);
  }

  @Override
  public void createPost(String title,String content,boolean published){
     newPostRepository.createPost(title,content,published);
  }

  @Override
  public List<NewPost> findByPublished(boolean published){
    return newPostRepository.findByPublished(true);
  }

}
