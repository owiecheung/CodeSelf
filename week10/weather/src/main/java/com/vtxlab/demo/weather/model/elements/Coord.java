package com.vtxlab.demo.weather.model.elements;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coord {
  

  // "lon": 10.99,
  // "lat": 44.34

  private Double lon;
  private Double lat;
}
