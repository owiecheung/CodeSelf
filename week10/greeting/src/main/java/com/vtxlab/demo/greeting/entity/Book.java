package com.vtxlab.demo.greeting.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table ( name = "BOOKS")
public class Book {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "B_NAME")
  private String bookName;

  @Column(name = "P_DATE")
  private LocalDate publicDate;

}
