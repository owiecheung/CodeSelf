package com.vtxlab.demo.weather.model;

import com.vtxlab.demo.weather.model.elements.Coord;
import com.vtxlab.demo.weather.model.elements.Main;
import com.vtxlab.demo.weather.model.elements.Sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordMainSysDto {
  
  private Coord coord;
  private Main main;
  private Sys sys;
}
