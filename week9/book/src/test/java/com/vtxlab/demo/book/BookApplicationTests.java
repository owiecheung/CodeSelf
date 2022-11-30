package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vtxlab.demo.book.controller.BookOperation;
import com.vtxlab.demo.book.service.BookService;

@SpringBootTest

class BookApplicationTests {

	@Autowired
	BookOperation bookOperation;

	//@Autowired
	//BookRepository bookRepository;

	@Autowired
	BookService bookService;


	@Test
	//@Disabled
	void contextLoads() {

		assertThat(bookOperation).isNotNull();
		//assertThat(bookRepository).isNotNull();
		assertThat(bookService).isNotNull();
	}

	

}
