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

public class Clouds implements Serializable{
  
  @JsonProperty("all")
  private BigDecimal cloudinessPercent;

  
}
