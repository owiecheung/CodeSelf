package com.vtxlab.demo.polygon.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.polygon.exception.ApiException;
import com.vtxlab.demo.polygon.model.CoinsExchange;
import com.vtxlab.demo.polygon.model.dto.ChannelDto;
import com.vtxlab.demo.polygon.model.dto.ChannelDto.ExchangeRate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CoinApi {

  @Autowired
  RestTemplate restTemplate;



  public <T> T invoke(String baseUrl,
  String serviceVers,
  String serviceUrl, 
  HashMap<String, String> queryParms,
  Class<T> returnType) throws ApiException {
try {
  UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
      .pathSegment(serviceVers) // api/v3
      .path(serviceUrl); // coins/markets

  for (Map.Entry<String, String> entry : queryParms.entrySet()) {
    url = url.queryParam(entry.getKey(), entry.getValue());
  }

  String urlString = url.build().toString();

  log.info("url={}", urlString);

  return restTemplate.getForObject(urlString, returnType);

    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80002, "Call polygon service fail.");
    }
  }


  public static List<ChannelDto.ExchangeRate> map(
    List<CoinsExchange> coinsExchanges) {

  List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>();

  for (CoinsExchange coinsExchange : coinsExchanges) {
    // Set Crypto to USD
    ExchangeRate exchangeRate = new ChannelDto().buildExchangeRate();
    exchangeRate.setFromCurr(coinsExchange.getTickerCryptoString());
    exchangeRate.setToCurr(coinsExchange.getTickerCurrencytring());
    exchangeRate.setRate(coinsExchange.getResults().get(0).getHighestPrice());  // TBC
    exchangeRates.add(exchangeRate);

    // Set USD to Crypto
    exchangeRate = new ChannelDto().buildExchangeRate();
    exchangeRate.setFromCurr(coinsExchange.getTickerCurrencytring());
    exchangeRate.setToCurr(coinsExchange.getTickerCryptoString());
    exchangeRate.setRate(BigDecimal.ONE.divide(
        coinsExchange.getResults().get(0).getHighestPrice(),  //TBC
        new MathContext(6, RoundingMode.HALF_UP)));   
    exchangeRates.add(exchangeRate);

    }
    return exchangeRates;
  }
}