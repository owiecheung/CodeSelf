package com.vtxlab.demo.student.service;

import java.util.List;

import com.vtxlab.demo.student.entity.Student;

public interface StudentService {
  

  Student getTommy();
  Student getOwie();

  List<Student> findAllStudents();

  List<Student> findByName(String name);

  List<Student> findByNameAndHeight(String name, Double height);

  Student findById(Long Id);

  void createStudent(String name,Double height);
}
