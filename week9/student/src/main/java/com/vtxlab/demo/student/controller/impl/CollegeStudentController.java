package com.vtxlab.demo.student.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.student.controller.StudentOperation;
import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.respone.ApiResponse;
import com.vtxlab.demo.student.service.StudentService;

@RestController
@RequestMapping(value = "/college/api/v1")
public class CollegeStudentController implements StudentOperation {
  

  @Autowired
  StudentService studentService;

  @Override
  public ResponseEntity<ApiResponse<List<Student>>> findAllStudents(){
    HttpStatus httpStatus = HttpStatus.OK;

    ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
    .code(httpStatus.value())
    .message("All students are below.")
    .data(studentService.findAllStudents())
    .build();

  return ResponseEntity.ok().body(response);
  }

  @Override
  public List<Student> findByName(String name){
    return studentService.findByName(name);
  }

  @Override
  public List<Student> findByNameAndHeight(String name, Double height){
    return studentService.findByNameAndHeight(name, height);
  }

  @Override
  public ResponseEntity<ApiResponse<Student>> findById(Long Id){
    HttpStatus httpStatus = HttpStatus.OK;
    String apiMsg = "This : " + Id ;

    ApiResponse<Student> response = ApiResponse.<Student>builder()
    .code(httpStatus.value())
    .message(apiMsg)
    .data(studentService.findById(Id))
    .build();

  return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Student>> createStudent(String name,Double height){
    studentService.createStudent(name,height);

    ApiResponse<Student> response = ApiResponse.<Student>builder()
    .code(140)
    .message("This student has been Created")
    .data(null)
    .build();

    return ResponseEntity.ok().body(response);
  }

}
