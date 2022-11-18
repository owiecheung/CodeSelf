package com.vtxlab.demo.post.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 *  select u.user_id,
    u.user_email as Email,
    p.id as "Post ID",
    p.title as "Title",
    p.content as Content
    
    from users u, posts p
    where u.user_id = p.user_id;
 */
public class UserDTO {
  
  
  private String user_id;

  private List<PostDTO> posts;

}
