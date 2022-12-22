package com.vtxlab.demo.crypto.model.currentExchange;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoinsCurrency implements Serializable{
  
  @JsonProperty("usd")
  private BigDecimal usd;

  @JsonProperty("hkd")
  private BigDecimal hkd;
}
