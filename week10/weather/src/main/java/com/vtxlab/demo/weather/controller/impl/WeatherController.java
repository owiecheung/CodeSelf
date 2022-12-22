package com.vtxlab.demo.weather.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vtxlab.demo.weather.controller.WeatherOperation;
import com.vtxlab.demo.weather.exception.ApiException;
import com.vtxlab.demo.weather.model.CoordMainSysDto;
import com.vtxlab.demo.weather.model.WindDto;
import com.vtxlab.demo.weather.model.dto.WeatherDto;
import com.vtxlab.demo.weather.model.elements.CurrentWeatherResponse;
import com.vtxlab.demo.weather.model.elements.Weather;
import com.vtxlab.demo.weather.response.Alert;
import com.vtxlab.demo.weather.response.ApiResponse;
import com.vtxlab.demo.weather.response.enums.ResponseStatus;
import com.vtxlab.demo.weather.service.WeatherService;
import com.vtxlab.demo.weather.utils.WeatherModelMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class WeatherController implements WeatherOperation {

  @Autowired
  // @Qualifier(value = "ModelMapper")
  ModelMapper modelMapper;

  @Autowired
  WeatherService weatherService;

  public static List<Alert> errAlerts = new ArrayList<>();

  @Override
  public ResponseEntity<ApiResponse<WeatherDto>> getWeatherMessage(BigDecimal lat, BigDecimal lon)  throws Exception{

    CurrentWeatherResponse currentWeatherResponse = weatherService.getWeatherMessage(lat, lon);

    if (currentWeatherResponse == null) {
      log.info("it is null");
    }

    Integer responseCode = currentWeatherResponse.getCod() == 200 ? //
    ResponseStatus.OK.getCode() :  ResponseStatus.THIRD_PARTY_API_FAIL.getCode();

    String responseMsg = currentWeatherResponse.getCod() == 200 ? //
    ResponseStatus.OK.getMessage() :  ResponseStatus.THIRD_PARTY_API_FAIL.getMessage();

    // if(weathers.getCod() == 200){
    //   responseCode = ResponseStatus.OK.getCode();
    //   responseMsg = ResponseStatus.OK.getMessage();
    // } else {
    //   responseCode = ResponseStatus.FAIL.getCode();
    //   responseMsg = ResponseStatus.FAIL.getMessage();
    // }

    WeatherDto weatherDto = WeatherModelMapper
                .convert(currentWeatherResponse);
    ApiResponse<WeatherDto> response = ApiResponse.<WeatherDto>builder()
        .code(responseCode)
        .message(responseMsg)
        .data(weatherDto)
        .alerts(errAlerts)
        .build();


    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<Weather>>> getWeather(BigDecimal lat, BigDecimal lon) throws ApiException {

    // List<AuthorDto> authorDtos = authorService.findAllAuthorss().stream()
    // .map(e -> {
    // List<BookDto> books = e.getBooks().stream() //
    // .map(b -> modelMapper.map(b, BookDto.class)) //
    // .collect(Collectors.toList());

    // return new AuthorDto(e.getId(), e.getAuthorName(),
    // e.getNationality(), books);
    // }).collect(Collectors.toList());

    // Weathers weathers = weatherService.getWeatherMessage(lat, lon);
    // List<Weather> dto = modelMapper.map(weatherService.getWeatherMessage(lat,
    // lon), List.class);
    // List<Weather> weather = weathers.getWeather().stream()
    // .map(b -> modelMapper.map(b, Weather.class))
    // .collect(Collectors.toList());
    // return weather;
    CurrentWeatherResponse weathers = weatherService.getWeatherMessage(lat, lon);
    Integer responseCode = weathers.getCod() == 200 ? //
    ResponseStatus.OK.getCode() :  ResponseStatus.THIRD_PARTY_API_FAIL.getCode();

    String responseMsg = weathers.getCod() == 200 ? //
    ResponseStatus.OK.getMessage() :  ResponseStatus.THIRD_PARTY_API_FAIL.getMessage();


    ApiResponse<List<Weather>> response = ApiResponse.<List<Weather>>builder()
          .code(responseCode)
          .message(responseMsg)
          .data(weatherService.getWeatherMessage(lat, lon).getWeather())
          .build();

    return ResponseEntity.ok().body(response);
  }

  @Override
  public CoordMainSysDto getCMS(BigDecimal lat, BigDecimal lon) throws ApiException{

    CoordMainSysDto dto = modelMapper.map(weatherService.getWeatherMessage(lat, lon), CoordMainSysDto.class);
    return dto;
  }

  @Override
  public WindDto getWind(BigDecimal lat, BigDecimal lon) throws Exception{
    WindDto dto = modelMapper.map(weatherService.getWeatherMessage(lat, lon), WindDto.class);
    return dto;
  }

}
