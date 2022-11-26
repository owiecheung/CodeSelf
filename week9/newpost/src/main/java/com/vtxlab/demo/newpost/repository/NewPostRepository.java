package com.vtxlab.demo.newpost.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.newpost.entity.NewPost;

@Repository
public interface NewPostRepository  extends JpaRepository<NewPost,Long> {
  


  @Query(nativeQuery = true, value = "INSERT INTO NEWPOSTS(TITLE,CONTENT,PUBLISHED) value (?1,?2,?3)")
  @Transactional
  @Modifying
  void createPost(
    @Param("TITLE")String title,
    @Param("CONTENT") String content, 
    @Param("PUBLISHED") boolean published);


    List<NewPost> findByPublished(boolean published);
}
