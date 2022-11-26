package com.vtxlab.demo.book.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.book.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
  
  //@Query(nativeQuery = true, value = "INSERT INTO BOOKS(B_NAME,P_DATE) value (?1,?2)")
  //@Transactional
  //@Modifying
  //void createBook(
    //@Param("bookName")String bookName,
    //@Param("publicDate") LocalDate lDate);

    Book findByBookName(String name);

    @Query(nativeQuery = true ,value = "DELETE from books b where b.author_id = :authorid")
    @Transactional
    @Modifying
    void deleteBooksByAuthorId(
      @Param("authorid")Long authorid);

      @Query(nativeQuery = true ,value = "select id,B_NAME,P_DATE from books b where b.author_id = :authorid")
      @Transactional
      @Modifying
      Integer findBooksByAuthorId(
        @Param("authorid")Long authorid);
  
}
