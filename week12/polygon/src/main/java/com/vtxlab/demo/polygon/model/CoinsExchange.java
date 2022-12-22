package com.vtxlab.demo.polygon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CoinsExchange implements Serializable {

  @JsonProperty("ticker")
  private String ticker;

  @JsonProperty("queryCount")
  private BigDecimal queryCount;

  @JsonProperty("resultsCount")
  private BigDecimal resultsCount;

  @JsonProperty("adjusted")
  private Boolean adjusted;

  @JsonProperty(value = "results")
  private List<ExchangeResult> results;

  @JsonProperty("status")
  private String status;
  
  @JsonProperty("request_id")
  private String request_id;

  @JsonProperty("count")
  private BigDecimal count;

  public String getTickerCryptoString(){
    return this.ticker.substring(2,5); //X:BTCUSD -> BTC
  }

  public String getTickerCurrencytring(){
    return this.ticker.substring(5,8); //X:BTCUSD -> USD
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ExchangeResult{
    
    @JsonProperty("T")
    private String ticker;

    @JsonProperty("v")
    private BigDecimal v;

    @JsonProperty("vw")
    private BigDecimal volumeWeight;

    @JsonProperty("o")
    private BigDecimal openPrice;

    @JsonProperty("c")
    private BigDecimal closePrice;

    @JsonProperty("h")
    private BigDecimal highestPrice;

    @JsonProperty("l")
    private BigDecimal lowestPrice;

    @JsonProperty("t")
    private BigDecimal startTimestamp;

    @JsonProperty("n")
    private BigDecimal numberOfTranstion;

  }
}
