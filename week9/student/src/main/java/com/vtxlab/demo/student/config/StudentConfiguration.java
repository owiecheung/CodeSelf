package com.vtxlab.demo.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vtxlab.demo.student.entity.Student;

@Configuration
public class StudentConfiguration {
  
  @Bean (name = "beanForTommy")
  public Student getTommy(){
    return new Student(2l, 180d, "Tommy");
  }

  @Bean (name = "beanForOwie")
	public Student getOwie(){
		return new Student(1l,110d,"owiecheung.c");
	}
}
