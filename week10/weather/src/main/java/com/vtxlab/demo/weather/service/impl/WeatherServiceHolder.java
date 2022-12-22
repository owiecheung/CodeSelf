package com.vtxlab.demo.weather.service.impl;


import java.math.BigDecimal;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.weather.exception.ApiException;
import com.vtxlab.demo.weather.model.elements.CurrentWeatherResponse;
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


  @Autowired
  RedisTemplate<String,CurrentWeatherResponse> redisTemplate;

  @Override
  public CurrentWeatherResponse getWeatherMessage(BigDecimal lat, BigDecimal lon) throws ApiException{
    
    //Key = openweather:weather:response
    //value = CurrentWeatherResponse
    //redisTemplate.opsForValue().set(appid, null);
    String redisKey = "openweather:weather:response";
    CurrentWeatherResponse weathers =redisTemplate.opsForValue().get(redisKey);

    if(weathers != null){
      return weathers;
    }
  
  
  try{
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

       // Call Open-Weather API
    RestTemplate restTemplate = new RestTemplate();
    weathers = restTemplate.getForObject(url, CurrentWeatherResponse.class);

    // Set to Redis with 10 minutes expiry
    redisTemplate.opsForValue().set(redisKey, weathers,
            Duration.ofSeconds(600));

        return weathers;

    } catch(Exception e) {
      e.printStackTrace();
  // WeatherController.errAlerts
  //.add(new Alert(80001,"Call Open-weather Service Fail"));
      throw new ApiException(80001,"Call Open-weather Service Fail");

    }


  }
  
}
