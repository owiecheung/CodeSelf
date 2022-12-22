package com.vtxlab.demo.polygon.service;

import java.util.List;

import com.vtxlab.demo.polygon.exception.ApiException;
import com.vtxlab.demo.polygon.model.CoinsExchange;



public interface PolygonService {
  
   List<CoinsExchange> getCoinExchangeList(List<String> cryptos, List<String> currency) throws ApiException;
}
