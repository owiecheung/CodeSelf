package com.vtxlab.demo.greeting.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.service.GreetingService;

import lombok.AllArgsConstructor;

@RestController // During start up, create bean to spring content
@RequestMapping (value  = "/api/v1")
@AllArgsConstructor
public class GreetingController implements GreetingOperation{
  
  @Autowired
  GreetingService greetingService;


  @Override
  public String greeting(){
    return greetingService.greeting() + " Owie";
  }

  @Override
  public List<Book> findAllBook(){
    return greetingService.findAllBook();
  }


  @Override
  public ResponseEntity<Book> findBookById(Long id){

    return ResponseEntity.ok().body(greetingService.findBookById(id));
  }

}
