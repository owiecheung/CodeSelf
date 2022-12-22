package com.vtxlab.demo.polygon.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.polygon.controller.PolygonOperation;
import com.vtxlab.demo.polygon.exception.ApiException;
import com.vtxlab.demo.polygon.model.dto.ChannelDto;
import com.vtxlab.demo.polygon.service.PolygonService;
import com.vtxlab.demo.polygon.utils.CoinApi;



@RestController
@RequestMapping (value = "/api/v1")
public class PolygonController implements PolygonOperation{
  
  @Autowired
  PolygonService polygonService;

  @Override
  public ChannelDto getCoinExchange(List<String> cryptos, List<String> currencies) throws ApiException{

    return ChannelDto.builder().exchangerate(
      CoinApi.map(polygonService.getCoinExchangeList(cryptos, currencies)))
      .build();
  }

}
