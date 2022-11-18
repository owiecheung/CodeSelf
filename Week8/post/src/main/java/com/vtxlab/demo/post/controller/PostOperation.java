package com.vtxlab.demo.post.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.model.UserDTO;
import com.vtxlab.demo.post.response.ApiResponse;



@RequestMapping(value = "default")
public interface PostOperation {
  
  @GetMapping(value = "/posts")
  List<Post> findAllPost();

  @PostMapping(value = "/posts")
  List<Post> saveAllPost(@RequestBody List<Post> posts);

  @GetMapping(value = "/posts/id/{id}")
  Post findPostById(@PathVariable Long id);

  @PostMapping ( value = "/post")
  ResponseEntity<ApiResponse<Post>> savePost(@RequestBody Post post) 
  throws KeyExistException;


  @DeleteMapping(value = "/posts")
  List<Post> delAll();

  @DeleteMapping(value = "/posts/id/{id}")
  ResponseEntity<ApiResponse<Post>> delPostById(@PathVariable Long id);

  @PutMapping( value = "/post")
  ResponseEntity<ApiResponse<Post>> updatePost (
    @RequestBody Post post);


  @GetMapping(value = "/posts/title/{title}")
  ResponseEntity<ApiResponse<List<Post>>>findByTitle(
    @PathVariable String title);


  @GetMapping(value = "/posts/titleCon/{title}")
  ResponseEntity<ApiResponse<List<Post>>>findByTitleContaining(
    @PathVariable String title);
    

  @GetMapping(value = "/posts/userId/{userId}")
  ResponseEntity<ApiResponse<UserDTO>> findPostsByUserId(
    @PathVariable String userId);

    /**
     * 
     *     @GetMapping(value = "/posts/userIdN/{userId}")
        ResponseEntity<ApiResponse<UserDTO>> findPostsByUserIdNotNative(
      @PathVariable String userId);
     */

}
