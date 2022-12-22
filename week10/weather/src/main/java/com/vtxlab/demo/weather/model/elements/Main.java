package com.vtxlab.demo.weather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main implements Serializable{
  
  // "temp": 298.48,
  // "feels_like": 298.74,
  // "temp_min": 297.56,
  // "temp_max": 300.05,
  // "pressure": 1015,
  // "humidity": 64,
  // "sea_level": 1015,
  // "grnd_level": 933

  @JsonProperty("temp")
  private BigDecimal temp;

  @JsonProperty("feels_like")
  private BigDecimal feels_like;

  @JsonProperty("temp_min")
  private BigDecimal temp_min;

  @JsonProperty("temp_max")
  private BigDecimal temp_max;
  
  @JsonProperty("pressure")
  private BigDecimal pressure;

  @JsonProperty("humidity")
  private BigDecimal humidity;

  // @JsonProperty("sea_level")
  // private BigDecimal sea_level;

  // @JsonProperty("grnd_level")
  // private BigDecimal grnd_level;





}
