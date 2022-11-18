package com.vtxlab.demo.post.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.exception.KeyNotFoundException;
import com.vtxlab.demo.post.model.PostDTO;
import com.vtxlab.demo.post.reporitory.PostReporitory;
import com.vtxlab.demo.post.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LihkgPostService implements PostService {
  
  @Autowired
  PostReporitory postReporitory; //  = new PostReporitory();

  @Override
  public List<Post> findAllPost(){
    return postReporitory.findAll();
  }

  
  @Override 
  public List<Post> saveAllPost(List<Post> posts){
    return postReporitory.saveAll(posts);
  }

  @Override
  public Post findPostById(Long id){
    return postReporitory.findById(id).orElse(null);
  }
    


  @Override
  public Post savePost(Post post) throws KeyExistException {
    if (findPostById(post.getId()) == null) {
      return postReporitory.save(post);
    }
    throw new KeyExistException();
  }

  @Override
  public List<Post> delAll(){
     postReporitory.deleteAll();
     return new ArrayList<>();
  }

  @Override
  public Post delPostById(Long id) throws IllegalArgumentException {

    Post post = postReporitory.findById(id).orElse(null);
    if(postReporitory.existsById(id)){
      postReporitory.deleteById(id);
      return post;
    }
      throw new KeyNotFoundException();
  }


  @Override
  public Post updatePost(Post post) throws IllegalArgumentException {
    if(postReporitory.existsById(post.getId())){
     return postReporitory.save(post);
    }
    throw new KeyNotFoundException(); 
  }


  @Override
  public List<Post> findByTitle(String title) throws IllegalArgumentException{
    return postReporitory.findByTitle(title); 
  }

  @Override
  public List<Post> findByTitleContaining(String title) throws IllegalArgumentException{

    return postReporitory.findByTitleContaining(title); 
  }


  @Override
  public List<PostDTO> findPostsByUserId(String userId) {
    List<PostDTO> postDtos = new ArrayList<>();

    // return List<Post>, and convert to List<PostDto>
    log.info("list.size {}", postReporitory.findPostsByUserId(userId).size());

    postReporitory.findPostsByUserId(userId).forEach(e -> {
      PostDTO postDto = PostDTO.builder() //
          .content(e.getContent())
          .title(e.getTitle())
          .build();
      // add the dto to list
      log.info("Start to proceed, postDto: {}", postDto.toString());
      postDtos.add(postDto);
    });
    return postDtos;
  }


/* 
  @Override
  public List<PostDTO> findPostsByUserIdNotNative(String userId) {
    List<PostDTO> postDtos = new ArrayList<>();

    // return List<Post>, and convert to List<PostDto>
    log.info("list.size {}", postReporitory.findPostsByUserIdNotNative(userId).size());

    postReporitory.findPostsByUserIdNotNative(userId).forEach(e -> {
      PostDTO postDto = PostDTO.builder() //
          .content(e.getContent())
          .title(e.getTitle())
          .build();
      // add the dto to list
      log.info("Start to proceed, postDto: {}", postDto.toString());
      postDtos.add(postDto);
    });
    return postDtos;
  }
*/
}
