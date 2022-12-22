package com.vtxlab.demo.weather.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.weather.model.CoordMainSysDto;
import com.vtxlab.demo.weather.model.WindDto;
import com.vtxlab.demo.weather.model.dto.WeatherDto;
import com.vtxlab.demo.weather.model.elements.CurrentWeatherResponse;
import com.vtxlab.demo.weather.model.elements.Weather;
import com.vtxlab.demo.weather.response.ApiResponse;

@RequestMapping(value = "/default")
public interface WeatherOperation {
  

  @GetMapping(value = "/weathers")
  ResponseEntity<ApiResponse<WeatherDto>> getWeatherMessage(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon)  throws Exception;

  @GetMapping(value = "/weathers/weather")
  ResponseEntity<ApiResponse<List<Weather>>> getWeather(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon) throws Exception;

  @GetMapping(value = "/weathers/cms")
  CoordMainSysDto getCMS(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon) throws Exception;

  @GetMapping(value = "/weathers/wind")
  WindDto getWind(@RequestParam BigDecimal lat, 
  @RequestParam BigDecimal lon) throws Exception;

}
