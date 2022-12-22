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
public class Sys implements Serializable{
  // "sys": {
  //   "type": 2,
  //   "id": 2075663,
  //   "country": "IT",
  //   "sunrise": 1661834187,
  //   "sunset": 1661882248

  @JsonProperty("type")
  private BigDecimal type;

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("country")
  private String country;

  @JsonProperty("sunrise")
  private BigDecimal sunrise;

  @JsonProperty("sunset")
  private BigDecimal sunset;

}
