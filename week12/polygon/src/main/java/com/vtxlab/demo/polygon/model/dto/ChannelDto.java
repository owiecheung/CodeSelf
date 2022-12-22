package com.vtxlab.demo.polygon.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelDto {
  
  List<ExchangeRate> exchangerate;

  public ExchangeRate buildExchangeRate(){
    return new ExchangeRate();
  }
  @Data
  public static class ExchangeRate{
    private String fromCurr;
    private String toCurr;
    private BigDecimal rate;
  }

}
