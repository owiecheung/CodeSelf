package com.vtxlab.demo.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.respone.ApiResponse;

@RequestMapping(value = "default")
public interface StudentOperation {
  
  @GetMapping(value = "/students")
  ResponseEntity<ApiResponse<List<Student>>> findAllStudents();

  @GetMapping(value = "/students/name/{name}")
  List<Student> findByName(
    @PathVariable String name);

    @GetMapping(value = "/students/{name}/{height}")
  List<Student> findByNameAndHeight(
    @PathVariable String name,
    @PathVariable Double height);


    @GetMapping(value = "/students/id/{Id}")
    ResponseEntity<ApiResponse<Student>>  findById(
      @PathVariable Long Id);

    @PostMapping(value = "/students/name/{name}/height/{height}")
    ResponseEntity<ApiResponse<Student>> createStudent(
      @PathVariable String name,
      @PathVariable Double height);
}
