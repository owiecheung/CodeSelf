package com.vtxlab.demo.student.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vtxlab.demo.student.entity.Student;

@Repository// bean = StudentRepository
//also is a kind of @Component

public interface StudentRepository extends JpaRepository<Student,Long> {
  //Runtime to create the method select * from ?

  List<Student> findByName(String name);

  List<Student> findByNameAndHeight(String name, Double height);

  @Query( nativeQuery = true,value = "INSERT INTO TSTUDENTS (S_NAME,S_HEIGHT) value (?1, ?2)" )
  @Transactional
  @Modifying
  void createStudent(
  @Param("name") String name,
  @Param("height") Double height);
}
