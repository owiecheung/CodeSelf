package com.vtxlab.demo.greeting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.greeting.entity.Book;


@RequestMapping("default")
public interface GreetingOperation {
  

  @GetMapping(value = "/greeting")
   String greeting();

   @GetMapping(value = "/books")
   List<Book> findAllBook();

   @GetMapping(value = "/book/{id}")
   ResponseEntity<Book> findBookById(@PathVariable Long id);

}
