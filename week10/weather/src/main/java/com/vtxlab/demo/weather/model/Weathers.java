package com.vtxlab.demo.weather.model;

import java.util.List;

import com.vtxlab.demo.weather.model.elements.Clouds;
import com.vtxlab.demo.weather.model.elements.Coord;
import com.vtxlab.demo.weather.model.elements.Main;
import com.vtxlab.demo.weather.model.elements.Rain;
import com.vtxlab.demo.weather.model.elements.Sys;
import com.vtxlab.demo.weather.model.elements.Weather;
import com.vtxlab.demo.weather.model.elements.Wind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weathers {
  
  private Coord coord;
  private List<Weather> weather;
  private String base;
  private Main main;
  private Integer visibility;
  private Wind wind;
  private Rain rain;
  private Clouds clouds;
  private Long dt;
  private Sys sys;
  private Integer timezone;
  private Long id;
  private String name;
  private Integer cod;



}
