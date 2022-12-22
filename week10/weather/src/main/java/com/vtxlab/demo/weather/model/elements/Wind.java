package com.vtxlab.demo.weather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wind implements Serializable{
  
  // "wind": {
  //   "speed": 0.62,
  //   "deg": 349,
  //   "gust": 1.18

  @JsonProperty("speed")
  private BigDecimal speed;

  @JsonProperty("deg")
  private BigDecimal deg;

  // @JsonProperty("gust")
  // private BigDecimal gust;

}
