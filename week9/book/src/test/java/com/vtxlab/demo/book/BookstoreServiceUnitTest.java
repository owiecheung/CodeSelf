package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.repository.BookRepository;
import com.vtxlab.demo.book.service.BookService;
import com.vtxlab.demo.book.service.impl.BookstoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
public class BookstoreServiceUnitTest {
  


  @Mock
  BookRepository bookRepository;


  private BookService bookService;

  @BeforeEach
  void setup() {
    bookService = new BookstoreService(bookRepository);
  }

  private void testServiceFindAllBooks(List<Book> booksFromService,int size){
    //Builder to build a book

    //Given (Mock)
    when(bookRepository.findAll()).thenReturn(booksFromService);

    //When
    List<Book> books =bookService.findAllBooks();
    log.info(books.toString());

    //Then
    assertThat(books).hasSize(size);
  }

  @Test
  void testCaseForServiceFindAllBooks() {

    Book book1 = new Book(1l,"Owie Books", LocalDate.of(2021, 10, 1), new Author());
    Book book2 = new Book(2l,"Leo Books", LocalDate.of(2022, 10, 1), new Author());
    testServiceFindAllBooks(List.of(book1,book2),2);
    testServiceFindAllBooks(List.of(book1), 1);
    testServiceFindAllBooks(new ArrayList<>(), 0);
  }

}
