package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.repository.BookRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ExtendWith(SpringExtension.class)
public class BookStoreJpaTest {
  

  @Autowired
  BookRepository bookRepository;

  @Autowired
  EntityManager entityManager;

  @BeforeEach
  void setup(){

  }

  @Test
  void testFindAll(){

    Book book1 = new Book(1l, "Fuukscsa Book", LocalDate.of(2022, 1, 1), 
    new Author(5l,"VVV","HK"));
    Book book2 = new Book(2l, "Leooooo Book", LocalDate.of(2022, 2, 1), 
    new Author(5l,"VVV","HK"));

  //  bookRepository.save(book1);
   // bookRepository.save(book2);
    bookRepository.saveAndFlush(book1);
    //when 
    List<Book> books = bookRepository.findAll();
    //then
    assertThat(books).hasSize(5);
  }
}
