package com.vtxlab.demo.newpost.controller.impl;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vtxlab.demo.newpost.controller.NewPostOperation;
import com.vtxlab.demo.newpost.entity.NewPost;
import com.vtxlab.demo.newpost.response.ApiResponse;
import com.vtxlab.demo.newpost.service.NewPostService;


@RestController
@RequestMapping(value = "/lihkg")
public class LihkgNewPostController implements NewPostOperation{

  @Autowired
  NewPostService newPostService;


  @Override
  public  ResponseEntity<ApiResponse<List<NewPost>>> findAllPost(){
    HttpStatus httpStatus = HttpStatus.OK;
    String msg = "Here is the post.";
    ApiResponse<List<NewPost>> response = ApiResponse.<List<NewPost>>builder()
                                          .code(httpStatus.value())
                                          .msg(msg)
                                          .data(newPostService.findAllPost())
                                          .build(); 

    return ResponseEntity.ok().body(response);
  }




  @Override
  public ResponseEntity<ApiResponse<Optional<NewPost>>> findPostById(Long id){

  Optional<NewPost> newPost =newPostService.findPostById(id);
    HttpStatus httpStatus = HttpStatus.OK;
    String msg = "Here is the post.";
    ApiResponse<Optional<NewPost>> response = ApiResponse.<Optional<NewPost>>builder()
                                          .code(httpStatus.value())
                                          .msg(msg)
                                          .data(newPost)
                                          .build(); 

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<NewPost>> createPost(NewPost post){
    URI location = ServletUriComponentsBuilder
    .fromCurrentRequest()
    .buildAndExpand()
    .toUri();

    String msg = "Success !  " + post + " has been created.";
    HttpStatus httpStatus = HttpStatus.CREATED;
    ApiResponse<NewPost> response = ApiResponse.<NewPost>builder()
    .code(httpStatus.value())
    .msg(msg)
    .data(post)
    .build();

    newPostService.createPost(post.getTitle(),post.getContent(),post.isPublished());
    return ResponseEntity.created(location).body(response);
  }

  public ResponseEntity<ApiResponse<List<NewPost>>> findByPublished() {
   
    List<NewPost> newPosts = newPostService.findByPublished(true);
    String msg = "Here is the result";
    HttpStatus httpStatus = HttpStatus.OK;
    ApiResponse<List<NewPost>> response = ApiResponse.<List<NewPost>>builder()
    .code(httpStatus.value())
    .msg(msg)
    .data(newPosts)
    .build();

    if (newPosts.isEmpty()) {

      return  ResponseEntity.noContent().build();
    }
    
    return ResponseEntity.ok().body(response);
  }
  
}
