package com.vtxlab.demo.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.book.reponse.ApiResponse;

@ControllerAdvice
public class GloblaExceptionHandler<T> {
  
  @ExceptionHandler({KeyExistException.class})
  public ResponseEntity<ApiResponse<T>> handleKeyException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(120,
    "Key is already Exist.",null));
  }

  @ExceptionHandler({KeyNotFoundExistException.class})
  public ResponseEntity<ApiResponse<T>> handleKeyNotFoundException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(),
    "Key Not Found", null));
  }

}
/**
 * 
 *   - /bookstore/books (Get method, return list of books)
    - Always 200 https status even if no books returned (empty list)
  - /bookstore/book/id/{id} (Get method, return a book)
    - 200 https status if book(s) is found
    - 204 https status if not found (tips: ResponseEntity.notfound())
  - /bookstore/book/id (Post method, with RequestBody, return nothing)
    - 201 https status if created (tips: ResponseEntity.created())
  - /bookstore/book/id/{id} (Delete method, return Boolean)
    - 201 https status if book(s) is deleted (return true)
    - 400 https status if no book(s) is found (return false)
 */