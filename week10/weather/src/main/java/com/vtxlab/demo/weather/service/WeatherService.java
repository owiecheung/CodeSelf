package com.vtxlab.demo.weather.service;

import java.math.BigDecimal;

import com.vtxlab.demo.weather.exception.ApiException;
import com.vtxlab.demo.weather.model.elements.CurrentWeatherResponse;

public interface WeatherService {
  

  CurrentWeatherResponse getWeatherMessage(BigDecimal lat, BigDecimal lon) throws ApiException;

 
}
