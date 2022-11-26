package com.vtxlab.demo.book.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
  

  private Long id;

  private String authorName;
  private String nationality;
  private List<BookDto> books;
}
