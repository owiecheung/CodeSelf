package com.vtxlab.demo.weather.model.elements;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wind {
  
  // "wind": {
  //   "speed": 0.62,
  //   "deg": 349,
  //   "gust": 1.18

    private BigDecimal speed;
    private Integer deg;
    private Long gust;

}
