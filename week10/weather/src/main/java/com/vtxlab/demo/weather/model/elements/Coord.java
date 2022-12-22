package com.vtxlab.demo.weather.model.elements;


import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coord implements Serializable{
  

  // "lon": 10.99,
  // "lat": 44.34
  @JsonProperty("lan")
  private BigDecimal lon;

  @JsonProperty("lon")
  private BigDecimal lat;
}
