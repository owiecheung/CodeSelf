package com.vtxlab.demo.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;


    /*
		 * 
		 * Accessing the database
		 * but the data are varible
		 * the test may be fail
		 */
		
@SpringBootTest // Complie time as pretend Springboot Application startup situation
//In this example, controller + Service will be created in spring context
@AutoConfigureMockMvc // Always use , so that springboot create this annotation
// To MockBean 過程
class GreetingApplicationTests {

	//TDD
	//interface is ensure those annotation are assigned @Restcontroller or @Service

	@Autowired
	GreetingOperation greetingOperation;

	@Autowired
	GreetingService greetingService;

	@Autowired
	GreetingRepository greetingRepository;

	@Autowired
	MockMvc mockMvc;

	@Test // represents this method will be run automatically for this test case
	void contextLoads() {
		// Mockito
		assertThat(greetingOperation).isNotNull();
		assertThat(greetingService).isNotNull();
		assertThat(greetingRepository).isNotNull();
	}

	@Test
	void testintegrationGreeting() throws Exception{
		mockMvc.perform(get("/api/v1/greeting"))
					.andExpect(status().isOk())
					.andExpect(content().string("abcd"));
	}



}
