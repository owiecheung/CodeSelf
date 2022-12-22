package com.vtxlab.demo.polygon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.polygon.exception.ApiException;
import com.vtxlab.demo.polygon.model.dto.ChannelDto;

@RequestMapping (value = "/default")
public interface PolygonOperation {
  

  @GetMapping(value = "/price")
  public ChannelDto getCoinExchange(
    @RequestParam(value = "coins") List<String> cryptos, 
    @RequestParam(value = "currencies") List<String> currencies) throws ApiException, JsonProcessingException;
  
}
