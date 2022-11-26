package com.vtxlab.demo.student.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.student.respone.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler<T> {
  
  @ExceptionHandler({KeyExistException.class})
  public ResponseEntity<ApiResponse<T>> handleKeyException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(120,
    "Key is already Exist.",null));
  }

  @ExceptionHandler({KeyNotFoundExistException.class})
  public ResponseEntity<ApiResponse<T>> handleKeyNotFoundException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(130,
    "Key Not Found", null));
  }


  @ExceptionHandler({CreateStudentHandler.class})
  public ResponseEntity<ApiResponse<T>> handleCreateStudent(){
   return ResponseEntity.ok().body(new ApiResponse<>(10,
   "This student has been create ",null));
  }
}
