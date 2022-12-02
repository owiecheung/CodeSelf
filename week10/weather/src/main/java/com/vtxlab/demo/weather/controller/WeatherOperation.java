package com.vtxlab.demo.weather.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.weather.model.CoordMainSysDto;
import com.vtxlab.demo.weather.model.Weathers;
import com.vtxlab.demo.weather.model.WindDto;
import com.vtxlab.demo.weather.model.elements.Weather;

@RequestMapping(value = "/default")
public interface WeatherOperation {
  

  @GetMapping(value = "/weathers")
  Weathers getWeatherMessage(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon);

  @GetMapping(value = "/weathers/weather")
  List<Weather> getWeather(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon);

  @GetMapping(value = "/weathers/cms")
  CoordMainSysDto getCMS(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon);

  @GetMapping(value = "/weathers/wind")
  WindDto getWind(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon);

}
