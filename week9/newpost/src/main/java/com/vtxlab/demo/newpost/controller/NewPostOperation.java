package com.vtxlab.demo.newpost.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.newpost.entity.NewPost;
import com.vtxlab.demo.newpost.response.ApiResponse;


@RequestMapping(name = "default")
public interface NewPostOperation {


  @GetMapping(value = "/newpost")
  ResponseEntity<ApiResponse<List<NewPost>>> findAllPost();


  @GetMapping(value = "/newpost/{id}")
  ResponseEntity<ApiResponse<Optional<NewPost>>> findPostById(
  @PathVariable Long id);

  @PostMapping(value = "/newpost")
  ResponseEntity<ApiResponse<NewPost>> createPost(
    @RequestBody NewPost post);

    @GetMapping(value = "/newpost/published")
    ResponseEntity<ApiResponse<List<NewPost>>> findByPublished();
}
