package com.vtxlab.demo.polygon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.polygon.exception.ApiException;
import com.vtxlab.demo.polygon.model.CoinsExchange;
import com.vtxlab.demo.polygon.service.PolygonService;
import com.vtxlab.demo.polygon.utils.CoinApi;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PolygonServiceHolder implements PolygonService{
  
  @Autowired
  CoinApi polygonApi;


  @Value("${polygon.baseUrl}")
  String baseUrl;

  @Value("${polygon.serviceVers}")
  String serviceVers;

  @Value("${polygon.service.previous.serviceUrl}")
  String serviceUrl;

  @Value("${polygon.adjusted}")
  String adjusted;

  @Value("${polygon.apiKey}")
  String apiKey;


  @Override
  public List<CoinsExchange> getCoinExchangeList(
    List<String> cryptos, List<String> currencies) throws ApiException{

      List<CoinsExchange> coinsExchanges = new ArrayList<>();
      for(String coin : cryptos){
        for(String curr : currencies){
          coinsExchanges.add(getCoinExchange(coin, curr));
        }
      }
    return coinsExchanges;
  }

  private CoinsExchange getCoinExchange(String crypto, String currency) throws ApiException{

    String updatedServiceUrl = serviceUrl.replace("{ticker}", "X:"+crypto+currency);

    log.info("updatedServiceUrl={}", updatedServiceUrl);

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("adjusted", adjusted);
    hMap.put("apiKey", apiKey);

    return polygonApi.invoke(baseUrl, serviceVers, 
    updatedServiceUrl, hMap, CoinsExchange.class);

  }
}
