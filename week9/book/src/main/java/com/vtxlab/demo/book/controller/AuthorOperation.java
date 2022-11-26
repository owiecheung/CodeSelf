package com.vtxlab.demo.book.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.model.AuthorDto;
import com.vtxlab.demo.book.reponse.ApiResponse;

@RequestMapping(value = "/default")
public interface AuthorOperation {
  

  @GetMapping(value = "/authorss")
  ResponseEntity<ApiResponse<List<AuthorDto>>> findAllAuthorss();

  @GetMapping(value = "/authors")
  ResponseEntity<ApiResponse<List<Author>>>  findAllAuthors();



  @GetMapping(value = "/author/{id}")
  ResponseEntity<ApiResponse<List<AuthorDto>>> findAuthorById(
    @PathVariable Long id);

  @GetMapping(value = "/authorbybook/{id}")
  ResponseEntity<ApiResponse<Author>> findAuthorByBookId(
    @PathVariable Long id);

  @DeleteMapping(value = "/authors/id/{id}")
  ResponseEntity<Void> deleteById(@PathVariable Long id);
}
