package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.book.controller.BookOperation;
import com.vtxlab.demo.book.controller.impl.BookstoreController;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.reponse.ApiResponse;
import com.vtxlab.demo.book.service.BookService;


@ExtendWith(SpringExtension.class) // @Mock , @MOckBean , @InjectMock(Must be class not interface)
public class BookControllerUnitTest {

  @Mock
  BookService bookService;

  private BookOperation bookOperation;

  @BeforeEach
  void setup() {
    bookOperation = new BookstoreController(bookService);
  }


  private void testControllerFindAllBooks(List<Book> booksFromService,int size){
    //Builder to build a book

    //Given (Mock)
    when(bookService.findAllBooks()).thenReturn(booksFromService);

    //When
    ResponseEntity<ApiResponse<List<Book>>> books =bookOperation.findAllBooks();

    //Then
  //  if(books.hasBody() && books.getBody() != null){
    assertThat(books.getBody().getData()).hasSize(size);
 //   }
  }

  @Test
  void testCaseForFindAllBooks() {
    testControllerFindAllBooks(List.of(new Book(), new Book()), 2);
    testControllerFindAllBooks(List.of(new Book()), 1);
    testControllerFindAllBooks(new ArrayList<>(), 0);
  }





  private void testFindBookById(Book book,Long id){
    when(bookService.findById(anyLong())).thenReturn(book);

    ResponseEntity<ApiResponse<Book>> aBook =bookOperation.findById(id);

    if(book != null){
    assertThat(aBook.getBody().getData().getBookName()).isEqualTo(book.getBookName());
    assertThat(aBook.getBody().getData().getId()).isEqualTo(book.getId());
    assertThat(aBook.getBody().getData().getAuthor()).isEqualTo(book.getAuthor());
    } else {
      assertThat(aBook.getBody()).isEqualTo(null);
    }
  }


  @Test
  void testCaseForFindBookById() {
    testFindBookById(null, 1l);
    testFindBookById(
      new Book(2l, "Tommy's Book", LocalDate.of(2022, 6,1),new Author()),
      2l);
  }

  // private void testCreateBook(Book book, Book returnBook){

  //   //when
  //   when(bookService.createBook(book));

  //   ResponseEntity<ApiResponse<Book>> newBook = bookOperation.createBook(book);

  //   //then
  //   if(returnBook != null){
  //     assertThat(returnBook.getBookName()).isEqualTo(newBook.getBody().getData().getBookName());
  //     assertThat(newBook.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  //   } else {
  //     assertThat(newBook.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  //   }
  // }

  // @Test
  // void testCaseForCreateBook(){
  //   Book book = new Book(1l, "Steve Book", LocalDate.of(2022, 4, 1), new Author());

  //  // testCreateBook(book,null); // key exist, creation is not required
  //  // testCreateBook(book, book); //creation success
  // }


  private void testDeleteBookByID(Long id, Book returnBook){
    when(bookService.deleteBookById(anyLong())).thenReturn(returnBook);

    ResponseEntity<ApiResponse<Book>> ControllerReturnedBook = bookOperation.deleteBookById(id);
    
    if(returnBook != null){
      //assertThat(ControllerReturnedBook.getBody().getData().getId()).isEqualTo(id);
      assertThat(ControllerReturnedBook.getBody().getData().getId()).isEqualTo(returnBook.getId());
      assertThat(ControllerReturnedBook.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    } else {
      assertThat(ControllerReturnedBook.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
  }

  @Test
  void testCaseForDeleteBookById(){

    testDeleteBookByID(1l,null);
    testDeleteBookByID(2l, new Book(2l,"Owie Book",LocalDate.of(2022,5, 1),new Author()));

  }
}