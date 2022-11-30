package com.vtxlab.demo.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.controller.impl.GreetingController;
import com.vtxlab.demo.greeting.service.GreetingService;

// this is testing the method , ensure it can run
//Junit 5
@ExtendWith(SpringExtension.class) // --> @Mock, @InjectMocks
public class GreetingControllerUnitTest {
  
  @Mock //No implememnt injected int this reference
  //Mock the dependency if greetingOperation
  GreetingService greetingService; // temp object  , not a class

  private GreetingOperation greetingOperation;

  
  @BeforeEach
  void setup(){
    greetingOperation = new GreetingController(greetingService);
  }

  
  private void testHelloworld(String input, String output, String notEqualOutput){
    // Mockito
    // Given
    Mockito.when(greetingService.greeting()).thenReturn(input);
    //When
    String string = greetingOperation.greeting();
    //Then
    if(output != null){
      Assertions.assertThat(string).isEqualTo(output);
    }
    if(notEqualOutput != null){
      Assertions.assertThat(string).isNotEqualTo(notEqualOutput);
    }
   
  }

  /*
   * Testing controller 複雜 test case
   * 封死可能性
   * 邊緣case
   */
  @Test
  void testcase(){
    //Test Equal an not equal
    testHelloworld("Hello World", "Hello Worldd","hello");
    testHelloworld("", "d","abb");
    testHelloworld("avv", "avvd","addv");
    // 100 case...
  }

}
