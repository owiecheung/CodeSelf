package com.vtxlab.demo.book.service;


import java.util.List;

import com.vtxlab.demo.book.entity.Book;

public interface BookService {
  

  List<Book> findAllBooks();

  Book findByBookName(String name);

  Book findById(Long id);

  void createBook(Book book);

  Book deleteBookById(Long id);

  Book updateBookById(Book book,Long id);

  Book updateBookName(Long id,String name);

  Boolean deleteBooksByAuthorId(Long authorId);
}
