package com.vtxlab.demo.crypto.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.crypto.exception.ApiException;
import com.vtxlab.demo.crypto.model.CoinsMarkets;
import com.vtxlab.demo.crypto.model.dto.CoinsCurrencyMap;

public interface CryptoService {
  

  List<CoinsMarkets> getAllCoinsMarkets() throws ApiException ;

  CoinsCurrencyMap getSimplePrices(List<String> cryptos,
  List<String> currencies) throws ApiException, JsonProcessingException;
}
