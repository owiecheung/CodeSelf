package com.vtxlab.demo.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.service.GreetingService;


@SpringBootTest // Complie time as pretend Springboot Application startup situation
//In this example, controller + Service will be created in spring context
class GreetingApplicationTests {

	//TDD
	//interface is ensure those annotation are assigned @Restcontroller or @Service
	@Autowired
	GreetingOperation greetingOperation;

	@Autowired
	GreetingService greetingService;

	@Test // represents this method will be run automatically for this test case
	void contextLoads() {
		// Mockito
		Assertions.assertThat(greetingOperation).isNotNull();
		Assertions.assertThat(greetingService).isNotNull();
	}

}
