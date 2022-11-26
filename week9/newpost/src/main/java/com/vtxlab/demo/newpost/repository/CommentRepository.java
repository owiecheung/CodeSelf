package com.vtxlab.demo.newpost.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vtxlab.demo.newpost.entity.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{

}
