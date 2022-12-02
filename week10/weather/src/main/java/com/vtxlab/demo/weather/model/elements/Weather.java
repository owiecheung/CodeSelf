package com.vtxlab.demo.weather.model.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {





//   "id": 501,
//   "main": "Rain",
//   "description": "moderate rain",
//   "icon": "10d"

  private Long id;
  private String main;
  private String description;
  private String icon;
  
}
