package com.vtxlab.demo.weather.controller.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.weather.controller.WeatherOperation;
import com.vtxlab.demo.weather.model.CoordMainSysDto;
import com.vtxlab.demo.weather.model.Weathers;
import com.vtxlab.demo.weather.model.WindDto;
import com.vtxlab.demo.weather.model.elements.Weather;
import com.vtxlab.demo.weather.service.WeatherService;

@RestController
@RequestMapping(value = "/api/v1")
public class WeatherController implements WeatherOperation{
  
  @Autowired
  // @Qualifier(value = "ModelMapper")
   ModelMapper modelMapper;

  @Autowired
  WeatherService weatherService;

  @Override
  public Weathers getWeatherMessage(BigDecimal lat, BigDecimal lon){

    return weatherService.getWeatherMessage(lat,lon);
  }




  public List<Weather> getWeather(BigDecimal lat, BigDecimal lon){

    // List<AuthorDto> authorDtos = authorService.findAllAuthorss().stream()
    // .map(e -> {
    //  List<BookDto> books = e.getBooks().stream() //
    //      .map(b -> modelMapper.map(b, BookDto.class)) //
    //      .collect(Collectors.toList());
  
    //   return new AuthorDto(e.getId(), e.getAuthorName(),
    //       e.getNationality(), books);
    // }).collect(Collectors.toList());

    Weathers weathers = weatherService.getWeatherMessage(lat, lon);
    //WeatherDto dto = modelMapper.map(weatherService.getWeatherMessage(lat, lon), WeatherDto.class);
   List<Weather> weather = weathers.getWeather().stream()
          .map(b -> modelMapper.map(b, Weather.class))
          .collect(Collectors.toList());
        return weather;
  }

    @Override
    public CoordMainSysDto getCMS(BigDecimal lat, BigDecimal lon){

      CoordMainSysDto dto = modelMapper.map(weatherService.getWeatherMessage(lat, lon), CoordMainSysDto.class);
      return dto;
    }

    @Override
    public WindDto getWind(BigDecimal lat, BigDecimal lon){
      WindDto dto = modelMapper.map(weatherService.getWeatherMessage(lat, lon), WindDto.class);
      return dto;
    }


}
