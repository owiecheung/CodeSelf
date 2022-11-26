package com.vtxlab.demo.book.service;

import java.util.List;
import java.util.Optional;

import com.vtxlab.demo.book.entity.Author;

public interface AuthorService {
  

  List<Author> findAllAuthorss();

  List<Author> findAllAuthors();

  Optional<Author>  findAuthorById(Long id);

  Author findAuthorByBookId(Long id);

  void deleteAuthor(Long id);

}
