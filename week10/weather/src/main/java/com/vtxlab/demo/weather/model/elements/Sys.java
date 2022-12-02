package com.vtxlab.demo.weather.model.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sys {
  // "sys": {
  //   "type": 2,
  //   "id": 2075663,
  //   "country": "IT",
  //   "sunrise": 1661834187,
  //   "sunset": 1661882248


  private Long type;
  private Long id;
  private String country;
  private Long sunrise;
  private Long sunset;

}
