package com.vtxlab.demo.crypto.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.crypto.exception.ApiException;
import com.vtxlab.demo.crypto.model.CoinsMarkets;
import com.vtxlab.demo.crypto.model.dto.CoinsCurrencyMap;
import com.vtxlab.demo.crypto.service.CryptoService;
import com.vtxlab.demo.crypto.utils.CoinsApi;



@Service
public class CryptoServiceHolder implements CryptoService{

  @Autowired
  CoinsApi coinsApi;
  
  @Value("${coingecko.baseUrl}")
  String baseUrl;
  @Value("${coingecko.serviceVers}")
  String serviceVers;
  @Value("${coingecko.service.coins-markets.serviceUrl}")
  String serviceUrl;
  @Value("${coingecko.service.coins-markets.currency}")
  String vsCurrency;
  @Value("${coingecko.service.coins-markets.order}")
  String order;
  @Value("${coingecko.service.coins-markets.perPage}")
  String perPage;
  @Value("${coingecko.service.coins-markets.page}")
  String page;
  @Value("${coingecko.service.coins-markets.sparkline}")
  String sparkline; // boolean
  @Value("${coingecko.service.simple-price.serviceUrl}")
  String simplePriceUrl;




  @Override
  public List<CoinsMarkets> getAllCoinsMarkets()throws ApiException  {

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("vs_currency", vsCurrency);
    hMap.put("order", order);
    hMap.put("per_page", perPage);
    hMap.put("page", page);
    hMap.put("sparkline", sparkline);


    return Arrays.asList(coinsApi.invoke(baseUrl, serviceVers, 
    serviceUrl, hMap, CoinsMarkets[].class));

   // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false

  }

  @Override
  public CoinsCurrencyMap getSimplePrices(List<String> cryptos,
      List<String> currencies) throws ApiException, JsonProcessingException {

    // Alternative: String.join(",", cryptos);
    String cryptoStr = cryptos.stream().collect(Collectors.joining(","));
    String currencyStr = currencies.stream().collect(Collectors.joining(","));

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("ids", cryptoStr);
    hMap.put("vs_currencies", currencyStr);

    return coinsApi.invoke(baseUrl,
        serviceVers, simplePriceUrl,
        hMap, CoinsCurrencyMap.class);

  };
}
