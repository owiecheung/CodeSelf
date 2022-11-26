package com.vtxlab.demo.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import lombok.extern.slf4j.Slf4j;


@SpringBootApplication //this include these three bleow
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan  // scan folder under  or same level of Student 
@Slf4j
public class StudentApplication {

	private static ConfigurableApplicationContext applicationContext;


	public static void main(String[] args) {
		applicationContext	= SpringApplication.run(StudentApplication.class, args);
		displayAllBeans();
	}

	public static void displayAllBeans(){
		String[] allBeanName = applicationContext.getBeanDefinitionNames();
		for(String s : allBeanName){
			log.info("\nBean : {}", s);
		}
	}

}
