package com.vtxlab.demo.newpost.service;

import java.util.List;
import java.util.Optional;

import com.vtxlab.demo.newpost.entity.NewPost;

public interface NewPostService {
  

  List<NewPost> findAllPost();

  Optional<NewPost> findPostById(Long id);

  void createPost(String title,String content,boolean published);

  List<NewPost> findByPublished(boolean published);
}
