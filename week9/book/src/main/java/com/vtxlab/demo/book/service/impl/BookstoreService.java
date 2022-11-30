package com.vtxlab.demo.book.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.repository.BookRepository;
import com.vtxlab.demo.book.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BookstoreService implements BookService {
  
  @Autowired
  BookRepository bookRepository;

  @Override
  public List<Book> findAllBooks(){
    return bookRepository.findAll();
  }

  @Override
  public Book findById(Long id){
    return bookRepository.findById(id).orElse(null);
  }

  @Override
  public Book findByBookName(String name){
    return bookRepository.findByBookName(name);
  }

  @Override
  public void createBook(Book book){
    bookRepository.save(book);
  }

  @Override
  public Book deleteBookById(Long id) {
    Book book = bookRepository.findById(id).orElse(null);
    if (bookRepository.existsById(id)){
      bookRepository.deleteById(id);
      return book;
    }
    return null;
 }

  @Override
  public Book updateBookById(Book book ,Long id){
    book.setId(id);
   return bookRepository.save(book);
  }

  @Override
  public Book updateBookName(Long id, String bName){
    if(bookRepository.existsById(id)){
      Book book = bookRepository.findById(id).orElse(null);
      book.setBookName(bName);
      return bookRepository.save(book);
    }
    return null;
  }

  @Override
  public Boolean deleteBooksByAuthorId(Long authorId) {
    Integer bookCount = bookRepository.findBooksByAuthorId(authorId);
    log.info("bookCount = {} ", bookCount);
    
    
    if (bookCount > 0) {
      bookRepository.deleteBooksByAuthorId(authorId);
      return true;
    }
    return false;
  }

}
