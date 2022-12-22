package com.vtxlab.demo.weather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Weather implements Serializable{





//   "id": 501,
//   "main": "Rain",
//   "description": "moderate rain",
//   "icon": "10d"

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("main")
  private String main;

  @JsonProperty("description")
  private String description;

  @JsonProperty("icon")
  private String icon;
  
}
