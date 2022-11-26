package com.vtxlab.demo.book.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.reponse.ApiResponse;


@RequestMapping(value = "default")
public interface BookOperation {
  

  @GetMapping(value = "/books")
  ResponseEntity<ApiResponse<List<Book>>> findAllBooks();

  @GetMapping(value = "/book/id/{id}")
  ResponseEntity<ApiResponse<Book>> findById(
    @PathVariable Long id);

  @PostMapping(value = "/book/id")
  ResponseEntity<ApiResponse<Book>> createBook(
    @RequestBody Book book);


  @DeleteMapping(value = "/book/id/{id}") 
  ResponseEntity<ApiResponse<Book>> deleteBookById(
    @PathVariable Long id);

  @GetMapping(value = "/book/name/{name}")
  ResponseEntity<ApiResponse<Book>> findByBookName(
    @PathVariable String name);

  @PutMapping(value = "/book/id/{id}")
  ResponseEntity<ApiResponse<Book>> updateBookById(
    @RequestBody Book book,
    @PathVariable Long id) ;
  

    @PatchMapping(value = "/book/id/{id}/name/{name}")
    ResponseEntity<Book> updateBookName(
      @PathVariable Long id , 
      @PathVariable String bName);
}
