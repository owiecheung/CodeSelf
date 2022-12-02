package com.vtxlab.demo.weather.model.elements;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class Main {
  
  // "temp": 298.48,
  // "feels_like": 298.74,
  // "temp_min": 297.56,
  // "temp_max": 300.05,
  // "pressure": 1015,
  // "humidity": 64,
  // "sea_level": 1015,
  // "grnd_level": 933

  private BigDecimal temp;
  private BigDecimal feels_like;
  private BigDecimal temp_min;
  private BigDecimal temp_max;
  private Integer pressure;
  private Integer humidity;
  private BigDecimal sea_level;
  private BigDecimal grnd_level;





}
