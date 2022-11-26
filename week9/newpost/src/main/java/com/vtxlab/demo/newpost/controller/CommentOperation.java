package com.vtxlab.demo.newpost.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.newpost.entity.Comment;
import com.vtxlab.demo.newpost.response.ApiResponse;


@RequestMapping(name = "default")
public interface CommentOperation {
  



  @GetMapping(value = "/comment/{id}")
  ResponseEntity<ApiResponse<Optional<Comment>>> findByPostId(
    @PathVariable Long id);
}
