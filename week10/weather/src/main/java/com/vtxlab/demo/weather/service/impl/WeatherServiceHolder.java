package com.vtxlab.demo.weather.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.weather.model.Weathers;
import com.vtxlab.demo.weather.model.elements.Weather;
import com.vtxlab.demo.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class WeatherServiceHolder implements WeatherService{
  
  // rest:
  // weather:
  //   baseUrl: https://api.openweathermap.org
  //   serviceVers: data/2.5
  //   serviceUrl: weather?
  //   querry: lat={lat}&lon={lon}&appid={appid}

  @Value("${rest.weather.baseUrl}")
  String baseUrl;

  @Value("${rest.weather.serviceVers}")
  String serviceVers;

  @Value("${rest.weather.serviceUrl}")
  String serviceUrl;

  @Value("${rest.weather.appid}")
  String appid;


  @Override
  public Weathers getWeatherMessage(BigDecimal lat, BigDecimal lon){

    String url = UriComponentsBuilder.fromUriString(baseUrl)
                .pathSegment(serviceVers)
                .path(serviceUrl)
                .queryParam("lat",lat)
                .queryParam("lon",lon)
                .queryParam("appid",appid)
                .build()
              //  .encode()
                .toString();
    log.info("url = {} " , url);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, Weathers.class);
  }
  

}
