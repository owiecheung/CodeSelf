package com.vtxlab.demo.post.service;

import java.util.List;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.model.PostDTO;



public interface PostService {



  List<Post> findAllPost();

  List<Post> saveAllPost(List<Post> posts);

  Post findPostById(Long id);

  Post savePost(Post post) throws KeyExistException;

  List<Post> delAll();

  Post delPostById(Long id);

  Post updatePost(Post post);


  List<Post> findByTitle(String title);

  List<Post> findByTitleContaining(String title);

  List<PostDTO> findPostsByUserId(String userId);

 // List<PostDTO>  findPostsByUserIdNotNative(String userId);
}
