package com.vtxlab.demo.book.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTHORS")
public class Author {
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "AUTHOR_NAME")
  private String authorName;

  @Column(name = "AUTHOR_NAT")
  private String nationality;


  @OneToMany(mappedBy = "author", fetch = FetchType.LAZY,
  cascade = CascadeType.PERSIST)
  @JsonIgnoreProperties({"author"})
  private List<Book> books;

  public Author(Long id, String authorName, String nationality){
    this.id = id;
    this.authorName = authorName;
    this.nationality = nationality;
  }
}
