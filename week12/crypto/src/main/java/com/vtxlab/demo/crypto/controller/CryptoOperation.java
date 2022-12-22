package com.vtxlab.demo.crypto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.crypto.exception.ApiException;
import com.vtxlab.demo.crypto.model.CoinsMarkets;
import com.vtxlab.demo.crypto.model.dto.ChannelDto;


@RequestMapping(value = "/default")
public interface CryptoOperation {
  

  @GetMapping(value = "/coin/market")
  List<CoinsMarkets> getCoinsMarkets() throws ApiException;

  //http://localhost:8085/api/v1/coingecko/simple-price?coins=bitcoin,ethereum,tether,dogecoin,ripple&currency=usd,hkd
  @GetMapping(value = "/coingecko/simple-price")
  ChannelDto getSimplePrices(@RequestParam("coins") List<String> cryptos,
      @RequestParam("currency") List<String> currencies)
      throws ApiException, JsonProcessingException;

  @GetMapping(value = "/splitcomma")
  public List<String> stringToList(@RequestParam("coins") List<String> coins);
    
}
