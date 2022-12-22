package com.vtxlab.demo.book.service;

import com.vtxlab.demo.book.entity.Book;

public interface GreetingService {
  
  String getGreetingMessage();

  Book findBookById(Long id);
}
