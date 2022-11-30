package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.demo.book.controller.impl.AuthorController;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.reponse.ApiResponse;
import com.vtxlab.demo.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest
public class BookControllerIntegrationTest {
  

  @MockBean
  BookService bookService;

  //@MockBean
  //BookRepository bookRepository;

  @Autowired
  MockMvc mockMvc;

  @MockBean
  AuthorController authorController;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void testWebMvc() throws Exception{
    //Given
    Book book1 = new Book(3l,"Owie's Book",LocalDate.of(2022,9, 20) ,new Author());
    Book book2 = new Book(5l,"vde's book",LocalDate.of(2023,11, 11), new Author());
   // List<Book> books = new ArrayList<>();
   //   books.add(book1);
   // books.add(book2);


    when(bookService.findAllBooks()).thenReturn(List.of(book1,book2));

    MvcResult result = mockMvc.perform(get("/api/v1/books"))
                      .andDo(print())
                 //     .andExpect(jsonPath("$.length()").value(2))
                  //    .andExpect(jsonPath("$[0].bookName").value("Owie's Book"))
                      .andExpect(status().isOk())
                      .andReturn();

    String string = result.getResponse().getContentAsString();
    ApiResponse response = objectMapper.readValue(string,ApiResponse.class);
    log.info(string);
    List<Book> bookList = (List<Book>) response.getData();

    assertThat(bookList).hasSize(2);

  }
}