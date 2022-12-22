package com.vtxlab.demo.crypto.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.crypto.controller.CryptoOperation;
import com.vtxlab.demo.crypto.exception.ApiException;
import com.vtxlab.demo.crypto.model.CoinsMarkets;
import com.vtxlab.demo.crypto.model.dto.ChannelDto;
import com.vtxlab.demo.crypto.service.CryptoService;
import com.vtxlab.demo.crypto.utils.CoinsApi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping (value = "/api/v1")
public class CryptoController implements CryptoOperation {
  
  @Autowired
  CryptoService cryptoService;


  @Override
  public List<CoinsMarkets> getCoinsMarkets() throws ApiException {
    log.info("start Controller");
    List<CoinsMarkets> coinsMarkets = cryptoService.getAllCoinsMarkets();
    log.info("end Controller: {}", coinsMarkets);
    return coinsMarkets;
  }


  @Override
  public ChannelDto getSimplePrices(List<String> cryptos,
      List<String> currencies) throws ApiException, JsonProcessingException {

    return ChannelDto.builder() //
        .exchangerate(CoinsApi.map(cryptoService
            .getSimplePrices(cryptos, currencies)))
        .build();
  }

  @Override
  public List<String> stringToList(List<String> coins) {
    return coins;
  }



}
