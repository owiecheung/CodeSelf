package com.vtxlab.crypto.channel.service.impl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.Channel;
import com.vtxlab.crypto.channel.model.ChannelTransaction;
import com.vtxlab.crypto.channel.model.dto.ChannelDto;
import com.vtxlab.crypto.channel.service.AdminService;
import com.vtxlab.crypto.channel.service.OrchestrationService;
import com.vtxlab.crypto.channel.service.ThirdPartyService;


@Service
public class OrchestrationServiceHolder implements OrchestrationService{

  @Autowired
  AdminService adminService;

  @Autowired
  ThirdPartyService thirdPartyService;

  final static String TRAN_TYPE_EX_RATE = "ex-rate";


  //Design Apporach 1 : have admin-service
  @Override
  public ChannelDto getExchangeRates(List<String> cryptos, List<String> currencies,
  String sourceApp) throws ApiException{

    Channel channel = adminService.getChannelBySourceAppAndTranType(sourceApp, TRAN_TYPE_EX_RATE);

    Predicate<ChannelTransaction> sourceAppCheck = e -> sourceApp.equals(e.getSourceApp());
    Predicate<ChannelTransaction> tranTypeCheck = e -> TRAN_TYPE_EX_RATE.equals(e.getTranType());

    ChannelTransaction channelTran = channel.getCoinTrans().stream()
        .filter(sourceAppCheck.and(tranTypeCheck)).findFirst().orElse(null);

    List<String> coinIds = channel.getCoinMaps().stream()// //Loop ChannelCoinMapping
      .map(e ->  e.getCoinId()).collect(Collectors.toList());


    return thirdPartyService.getThirdPartyExchangeRates(coinIds, currencies, 
    channel.getChannelUrl(), channelTran.getDomainVersion(), channelTran.getDomainUrl());

  }
}
  //Design Apporach 2 : Assume all third API service mapping coded in channel service
