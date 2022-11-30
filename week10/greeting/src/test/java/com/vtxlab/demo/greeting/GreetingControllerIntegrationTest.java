package com.vtxlab.demo.greeting;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;

import lombok.extern.slf4j.Slf4j;


/*
 * simluation the postman function
 * 模擬postman 扮api 輸出輸入
 * 
 * try to call the error URL ?
 * 
 */
@Slf4j
@WebMvcTest  // Start spring context, but with Controller,etc  related bean ONLY
//Not include Service and Repository
//So Service and Repository need @MockBean
@AutoConfigureMockMvc
public class GreetingControllerIntegrationTest {
  
  @MockBean  //create new bean to spring context 
  GreetingService greetingService; // will npe 入面冇野 冇instance

  @MockBean //create new bean to spring context 
  GreetingRepository greetingRepository;

  @Autowired // Due to @WebMvctest , the mockMvc Bean has been loaded to context
  MockMvc mockMvc; //Just like postman for testing //only controller 

  @Autowired // MockMvc will startup the Configuration
  ObjectMapper objectMapper;

  @Test
  void testWebMvc() throws Exception {
    //Given
    Mockito.when(greetingService.greeting()).thenReturn("abc");
    //When
    MockHttpServletRequestBuilder builder = //
        MockMvcRequestBuilders.get("/api/v1/greeting");
    //Ececute the call
    ResultActions response = mockMvc.perform(builder);
// check if the http response is 200
    StatusResultMatchers status = MockMvcResultMatchers.status();
    ResultMatcher statusOK = status.isOk(); //200
    response.andExpect(statusOK);

    ContentResultMatchers content = MockMvcResultMatchers.content();
    ResultMatcher contentHelloWorld = content.string("abcd");
    response.andExpect(contentHelloWorld);
  }


  @Test
  void testMvc2() throws Exception{
    when(greetingService.greeting()).thenReturn("abc");
    mockMvc.perform(get("/api/v1/greeting"))
           .andExpect(status().isOk())
           .andExpect(content().string("abcd"));
  }


  @Test
  void testFindAllBooks() throws Exception{
    Book book = new Book(1l,"TT's Book",LocalDate.of(2022, Month.JUNE, 18));
    List<Book> books = new ArrayList<>();
    books.add(book);
      when(greetingService.findAllBook()).thenReturn(books);

    MvcResult result =  mockMvc.perform(get("/api/v1/books"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    String string = result.getResponse().getContentAsString();
    log.info(string);


     //  ObjectMapper objectMapper = new ObjectMapper();
    // Deserialization
    List<Book>  bookList = objectMapper.readValue(string, List.class);
    log.info("\n\nbookList.size() = {} \n", bookList.size());
    assertThat(bookList.size()).isEqualTo(1);
  }



}

