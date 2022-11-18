package com.vtxlab.demo.post.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity told JPA this class to connect the database

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POSTS")
public class Post {
  
  @Id
  private Long id; //Unqie

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "TITLE")
  private String title;

  //Getter , Setter
}
