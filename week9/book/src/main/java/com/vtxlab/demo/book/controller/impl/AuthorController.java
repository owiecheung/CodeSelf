package com.vtxlab.demo.book.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.book.controller.AuthorOperation;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.model.AuthorDto;
import com.vtxlab.demo.book.model.BookDto;
import com.vtxlab.demo.book.reponse.ApiResponse;
import com.vtxlab.demo.book.service.AuthorService;


@RestController
@RequestMapping(value = "api/v1")
public class AuthorController implements AuthorOperation {


  @Autowired
//  @Qualifier(value = "AuthorService")
  AuthorService authorService;

  @Autowired
 // @Qualifier(value = "ModelMapper")
  ModelMapper modelMapper;

  @Override
  public ResponseEntity<ApiResponse<List<AuthorDto>>> findAllAuthorss() {
    List<AuthorDto> authorDtos = authorService.findAllAuthorss().stream()
          .map(e -> {
           List<BookDto> books = e.getBooks().stream() //
               .map(b -> modelMapper.map(b, BookDto.class)) //
               .collect(Collectors.toList());

            return new AuthorDto(e.getId(), e.getAuthorName(),
                e.getNationality(), books);
          }).collect(Collectors.toList());


      String msg = "All Authors is here.";
      HttpStatus httpStatus = HttpStatus.OK;
      ApiResponse<List<AuthorDto>> response = ApiResponse.<List<AuthorDto>>builder()
                              .code(httpStatus.value())
                              .msg(msg)
                              .data(authorDtos)
                              .build();

    return ResponseEntity.ok().body(response);
  }


  @Override
  public ResponseEntity<ApiResponse<List<Author>>> findAllAuthors(){
    ApiResponse<List<Author>> response = ApiResponse.<List<Author>>builder()
          .code(0)
          .msg(null)
          .data(authorService.findAllAuthors())
          .build();
    
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<AuthorDto>>> findAuthorById(Long id){

    List<AuthorDto> authorDto = authorService.findAuthorById(id).stream()
                      .map(e -> {
                List<BookDto> books = e.getBooks().stream()
                          .map(b -> modelMapper.map(b, BookDto.class))
                          .collect(Collectors.toList());
                    return new AuthorDto(e.getId(), e.getAuthorName(), 
                    e.getNationality(), books);
                      }).collect(Collectors.toList());  

      String msg = "ID : " + id + " Author is here.";
      HttpStatus httpStatus = HttpStatus.OK;
      ApiResponse<List<AuthorDto>> response = ApiResponse.<List<AuthorDto>>builder()
                              .code(httpStatus.value())
                              .msg(msg)
                              .data(authorDto)
                              .build();

    return ResponseEntity.ok().body(response);
  }


  @Override
  public ResponseEntity<ApiResponse<Author>> findAuthorByBookId(Long id){
    String msg = "THE AUTHOR OF THIS BOOK ID : " + id ;
    HttpStatus httpStatus = HttpStatus.OK;
    ApiResponse<Author> response = ApiResponse.<Author>builder()
                .code(httpStatus.value())
                .msg(msg)
                .data(authorService.findAuthorByBookId(id))
                .build();

    if(authorService.findAuthorByBookId(id) == null){
    return ResponseEntity.noContent().build();
    } 
    return ResponseEntity.ok().body(response);
  }

  
  @Override
  public ResponseEntity<Void> deleteById(Long id) {
    authorService.deleteAuthor(id);
    return ResponseEntity.ok().build();
  }


}
