package com.vtxlab.demo.greeting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.service.GreetingService;


//Junit 5
@ExtendWith(SpringExtension.class) // --> @Mock, @InjectMocks
public class GreetingControllerUnitTest {
  
  @Mock
  GreetingService greetingService;

  private GreetingOperation greetingOperation;

  @BeforeEach
  void setup(){

  }
}
