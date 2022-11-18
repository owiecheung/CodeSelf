package com.vtxlab.demo.post.controller.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.post.controller.PostOperation;
import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.model.PostDTO;
import com.vtxlab.demo.post.model.UserDTO;
import com.vtxlab.demo.post.response.ApiResponse;
import com.vtxlab.demo.post.service.PostService;

@RestController
@RequestMapping(value = "/lihkg/api/v1")
public class LihkgPostController implements PostOperation{
  
  @Autowired
  PostService postService;

  @Override
  public List<Post> findAllPost(){
    return postService.findAllPost();
  }

  @Override
  public List<Post> saveAllPost(List<Post> posts){
    return postService.saveAllPost(posts);
  }

  @Override
  public Post findPostById(Long id){
    return postService.findPostById(id);
  }

  @Override
  public ResponseEntity<ApiResponse<Post>> savePost(Post post)
      throws KeyExistException {
    ApiResponse<Post> response = ApiResponse.<Post>builder()//
        .code(HttpStatus.OK.value())
        .message("OK")
        .data(postService.savePost(post))
        .build();
    return ResponseEntity.badRequest().body(response);
  }

  @Override
  public List<Post> delAll(){
    return postService.delAll();
  }

  @Override
  public ResponseEntity<ApiResponse<Post>> delPostById(Long id){
      ApiResponse<Post> response = ApiResponse.<Post>builder()
          .code(HttpStatus.OK.value())
          .message("This : " + id + " has been deleted !")
          .data(postService.delPostById(id))
          .build();

    return ResponseEntity.badRequest().body(response);
  }
  

  @Override
  public ResponseEntity<ApiResponse<Post>> updatePost(Post post){
    ApiResponse<Post> response = ApiResponse.<Post>builder()
    .code(HttpStatus.OK.value())
    .message("This : " + post + " has been updated !")
    .data(postService.updatePost(post))
    .build();

return ResponseEntity.ok().body(response);

  }


  @Override
  public ResponseEntity<ApiResponse<List<Post>>> findByTitle(String title){

    HttpStatus httpStatus = HttpStatus.OK;
    String apiMsg = "This : " + title + " has been found !";

    if(postService.findByTitleContaining(title) == null){
      httpStatus = HttpStatus.BAD_REQUEST;
      apiMsg = "Result :" + title + "\nThere is no post with this title.";
    }

    ApiResponse<List<Post>> response = ApiResponse.<List<Post>>builder()
    .code(httpStatus.value())
    .message(apiMsg)
    .data(postService.findByTitle(title))
    .build();

    return ResponseEntity.ok().body(response);
  }


  @Override
  public ResponseEntity<ApiResponse<List<Post>>> findByTitleContaining(String title){
    HttpStatus httpStatus = HttpStatus.OK;
    String apiMsg = "This : " + title + " has been found !";

    ApiResponse<List<Post>> response = ApiResponse.<List<Post>>builder()
    .code(httpStatus.value())
    .message(apiMsg)
    .data(postService.findByTitleContaining(title))
    .build();

    if(postService.findByTitleContaining(title) == null){
      httpStatus = HttpStatus.BAD_REQUEST;
      apiMsg = "Result :" + title + "\nThere is no post with this title.";

      return ResponseEntity.badRequest().body(response);
    } else {
      return ResponseEntity.ok().body(response);
    }
  }



  @Override
  public  ResponseEntity<ApiResponse<UserDTO>> findPostsByUserId(String userId){
    HttpStatus httpStatus = HttpStatus.OK;
    String apiMsg = "This : " + userId + " has been found !";

    List<PostDTO> postDtos = postService.findPostsByUserId(userId);
    UserDTO userDto = UserDTO.builder()
                              .user_id(userId)
                              .posts(postDtos)
                              .build();

    ApiResponse<UserDTO> response = ApiResponse.<UserDTO>builder()
                                   .code(httpStatus.value())
                                   .message(apiMsg)
                                   .data(userDto)
                                   .build();

      return ResponseEntity.ok().body(response);
  }

/* 
  @Override
  public  ResponseEntity<ApiResponse<UserDTO>> findPostsByUserIdNotNative(String userId){
    HttpStatus httpStatus = HttpStatus.OK;
    String apiMsg = "This : " + userId + " has been found !";

    List<PostDTO> postDtos = postService.findPostsByUserIdNotNative(userId);
    UserDTO userDto = UserDTO.builder()
                              .user_id(userId)
                              .posts(postDtos)
                              .build();

    ApiResponse<UserDTO> response = ApiResponse.<UserDTO>builder()
                                   .code(httpStatus.value())
                                   .message(apiMsg)
                                   .data(userDto)
                                   .build();

      return ResponseEntity.ok().body(response);
  }
  */
}
