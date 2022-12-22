package com.vtxlab.demo.weather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentWeatherResponse implements Serializable{
  
  @JsonProperty("coord")
  private Coord coord;

  @JsonProperty("weather")
  private List<Weather> weather;

  @JsonProperty("base")
  private String base;

  @JsonProperty("main")
  private Main main;


  private BigDecimal visibility;

  @JsonProperty("wind")
  private Wind wind;

  // @JsonProperty("rain")
  // private Rain rain;

  @JsonProperty("clouds")
  private Clouds clouds;

  @JsonProperty("dt")
  private BigDecimal dt;

  @JsonProperty("sys")
  private Sys sys;

  @JsonProperty("timezone")
  private BigDecimal timezone;

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("cod")
  private Integer cod;

  

}
