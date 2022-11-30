package com.vtxlab.demo.book.controller.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vtxlab.demo.book.controller.BookOperation;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.reponse.ApiResponse;
import com.vtxlab.demo.book.service.BookService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class BookstoreController implements BookOperation {

  @Autowired
  BookService bookService;

  @Override
  public ResponseEntity<ApiResponse<List<Book>>> findAllBooks() {

    String msg = "All Books are below.";
    HttpStatus httpStatus = HttpStatus.OK;
    ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
        .code(httpStatus.value())
        .msg(msg)
        .data(bookService.findAllBooks())
        .build();

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Book>> findById(Long id) {

    ApiResponse<Book> response = ApiResponse.<Book>builder()
        .code(HttpStatus.OK.value())
        .msg("The Result of This ID : " + id)
        .data(bookService.findById(id))
        .build();

    if (bookService.findById(id) == null) {
      return ResponseEntity.noContent().build();
    } else
      return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Book>> findByBookName(String name) {

    String msg = "Here is the result.";
    HttpStatus httpStatus = HttpStatus.OK;
    ApiResponse<Book> response = ApiResponse.<Book>builder()
        .code(httpStatus.value())
        .msg(msg)
        .data(bookService.findByBookName(name))
        .build();

    if (bookService.findByBookName(name) == null) {
      msg = "There is not have this book.";
      httpStatus = HttpStatus.BAD_REQUEST;
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Book>> createBook(Book book) {
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .buildAndExpand()
        .toUri();

    String msg = "Success ! ID : " + book + " has been created.";
    HttpStatus httpStatus = HttpStatus.CREATED;
    ApiResponse<Book> response = ApiResponse.<Book>builder()
        .code(httpStatus.value())
        .msg(msg)
        .data(book)
        .build();

    if (bookService.findByBookName(book.getBookName()) != null) {
      msg = "There is already have the same book";
      httpStatus = HttpStatus.BAD_REQUEST;
      return ResponseEntity.badRequest().body(response);
    }
    bookService.createBook(book);
    return ResponseEntity.created(location).body(response);

  }

  @Override
  public ResponseEntity<ApiResponse<Book>> deleteBookById(Long id) {
    String msg = "Success ! ID : " + id + " has been deleted.";
    HttpStatus httpStatus = HttpStatus.OK;
    Book returnbook = bookService.deleteBookById(id);

    if (returnbook == null) {
      httpStatus = HttpStatus.BAD_REQUEST;
      msg = "Fail ! ID : " + id + " does not exist anymore or has been deleted.";
    }

    ApiResponse<Book> response = ApiResponse.<Book>builder()
        .code(httpStatus.value())
        .msg(msg)
        .data(returnbook)
        .build();

    if (returnbook == null) {
      return ResponseEntity.badRequest().body(response);
    }
    return ResponseEntity.created(null).body(response);

  }

  @Override
  public ResponseEntity<ApiResponse<Book>> updateBookById(Book book, Long id) {
    String msg = "Success ! ID : " + id + " has been updated.";
    HttpStatus httpStatus = HttpStatus.OK;

    ApiResponse<Book> response = ApiResponse.<Book>builder()
        .code(httpStatus.value())
        .msg(msg)
        .data(bookService.updateBookById(book, id))
        .build();

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<Book> updateBookName(Long id, String bName) {
    Book updateBook = bookService.updateBookName(id, bName);
    if (updateBook == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(updateBook);
  }

}
