package com.vtxlab.demo.book.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.repository.AuthorRepository;
import com.vtxlab.demo.book.service.AuthorService;


@Service
public class AuthorServiceHolder  implements AuthorService{
  
  @Autowired
  AuthorRepository authorRepository;

  private Boolean existById(Long id) {
    return authorRepository.existsById(id);
  }

  @Override
  public List<Author> findAllAuthorss() {
   return authorRepository.findAll();
  }

  @Override
  public List<Author> findAllAuthors(){
    return authorRepository.findAll();
  }

  @Override
  public Optional<Author> findAuthorById(Long id){
    return authorRepository.findById(id);
  }

  @Override
  public Author findAuthorByBookId(Long id){
    return authorRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteAuthor(Long id) {
    if (existById(id)) {
      authorRepository.deleteById(id);
    }
    return;
  }

}
