package com.vtxlab.demo.weather.service;

import java.math.BigDecimal;

import com.vtxlab.demo.weather.model.Weathers;

public interface WeatherService {
  

  Weathers getWeatherMessage(BigDecimal lat, BigDecimal lon);

 
}
