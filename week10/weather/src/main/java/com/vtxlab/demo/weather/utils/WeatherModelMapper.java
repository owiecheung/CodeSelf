package com.vtxlab.demo.weather.utils;

import com.vtxlab.demo.weather.model.dto.CurrentWeatherDto;
import com.vtxlab.demo.weather.model.dto.WeatherDto;
import com.vtxlab.demo.weather.model.elements.CurrentWeatherResponse;

public class WeatherModelMapper {

  public static WeatherDto convert(CurrentWeatherResponse cwr) {
    if (cwr == null) {
      return null;
    }
    CurrentWeatherDto currentWeatherDto = //
    CurrentWeatherDto.builder()
            .latitude(cwr.getCoord().getLat())
            .longitude(cwr.getCoord().getLon())
            .cityId(cwr.getId())
            .cityName(cwr.getName())
            .humidity(cwr.getMain().getHumidity())
            .cloudinessPercent(cwr.getClouds().getCloudinessPercent())
            .build();


    return WeatherDto.builder().currentWeatherDto(currentWeatherDto).build();
  }
}