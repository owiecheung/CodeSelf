package com.vtxlab.demo.post.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
  
  @JsonProperty (value = "PostTitle")
  private String title;

  @JsonProperty (value = "PostContent")
  private String content;

}
