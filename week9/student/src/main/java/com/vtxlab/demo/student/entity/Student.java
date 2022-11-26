package com.vtxlab.demo.student.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table( name = "tstudents")
public class Student {
  
  @Id
  @Column (name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  @Column (name = "S_HEIGHT")
  private Double height;

  @Column(name = "S_NAME")
  private String name;


}
