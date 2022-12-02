package com.vtxlab.demo.weather.model;

import com.vtxlab.demo.weather.model.elements.Wind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindDto {
  

  private Wind wind;
}
