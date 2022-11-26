package com.vtxlab.demo.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.repository.StudentRepository;
import com.vtxlab.demo.student.service.StudentService;

@Service
public class CollegeStudentService implements StudentService{
  
  @Autowired 
  // if no qualifier and there is only class implement the interface
  //the object refercence name is not important for finding the bean
  StudentRepository studentRepository;

  @Autowired // if there is qualifier , Qualifier name = bean name
  @Qualifier(value = "beanForTommy")
  Student studentTommy;

  @Autowired 
  @Qualifier(value = "beanForOwie")
  Student studentOwie;

  @Override
  public  Student getTommy(){
    return studentTommy;
  }

  @Override
  public  Student getOwie(){
    return studentOwie;
  }

  @Override
  public List<Student> findAllStudents(){
    return studentRepository.findAll();
  }

  @Override
  public List<Student> findByName(String name){
    
    return studentRepository.findByName(name);
  }

  @Override
  public List<Student> findByNameAndHeight(String name, Double height){
    return studentRepository.findByNameAndHeight(name, height);
  }

  @Override
  public Student findById(Long Id){
      return studentRepository.findById(Id).orElse(null);
  }


  @Override
  public void createStudent(String name, Double height){
    if(studentRepository.findByName(name).size() == 0){
   studentRepository.createStudent(name,height);
  } 
  }
}
