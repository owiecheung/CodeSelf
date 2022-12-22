package com.vtxlab.crypto.admin.model;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto {
  private Long channelId;
  private String channelCode;
  private String channelUrl;
  private List<ChannelCoinMappingDto> coinMap;

  public ChannelCoinMappingDto getChannelCoinMappingDto(){
    return new ChannelCoinMappingDto();
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ChannelCoinMappingDto{
    private Long channelId;
    private String channelCode;
    private String coinCode;
    private String coinId;
  }
}
