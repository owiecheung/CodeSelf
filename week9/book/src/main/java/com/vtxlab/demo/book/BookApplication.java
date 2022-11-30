package com.vtxlab.demo.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BookApplication {

	public static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext =	SpringApplication.run(BookApplication.class, args);

	}

	public static void displayAllBeans(){
		try {
			String[] allBeanNames = applicationContext.getBeanDefinitionNames();
			for(String a : allBeanNames ){
				log.info("\nBean : {}",a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		}
	}


