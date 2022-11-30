package com.vtxlab.demo.post.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.post.entity.Post;

//JPA is a agaent of the database and POST table
@Repository
public interface PostReporitory extends JpaRepository<Post, Long>{  // <Post (result set),Long (PK)>
  
  /**
   * This is selecting posts where title = somthing
   * @param title Title as User input
   * @return List of posts
   */
  
  List<Post> findByTitle(String title);

  //LIKE
  List<Post> findByTitleContaining(String title);

  //%Like%
  List<Post> findByTitleLike(String title);


  @Query( nativeQuery = true , value =  "select p.id, p.title, p.content from users u, posts p where u.user_id=p.user_id and u.user_id = :abc")
  List<Post> findPostsByUserId(@Param("abc") String userId);


// JPQL
  //@Query("SELECT p FROM post p")
  //List<Post> findPostsByUserIdNotNative( String userId);

}