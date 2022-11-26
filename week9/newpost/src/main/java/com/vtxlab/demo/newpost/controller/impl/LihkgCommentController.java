package com.vtxlab.demo.newpost.controller.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.newpost.controller.CommentOperation;
import com.vtxlab.demo.newpost.entity.Comment;
import com.vtxlab.demo.newpost.response.ApiResponse;
import com.vtxlab.demo.newpost.service.CommentService;


@RestController
@RequestMapping(value = "/lihkg")
public class LihkgCommentController implements CommentOperation{
  

  @Autowired
  CommentService commentService;

  @Override
  public ResponseEntity<ApiResponse<Optional<Comment>>> findByPostId(Long id){

    String msg = "Here is the result";
    HttpStatus httpStatus = HttpStatus.OK;
    Optional<Comment> rtnC = commentService.findByPostId(id);
    ApiResponse<Optional<Comment>> response = ApiResponse.<Optional<Comment>>builder()
                              .code(httpStatus.value())
                              .msg(msg)
                              .data(rtnC)
                              .build();

        if(rtnC.isEmpty()){
          return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(response);
  }
}

