package com.vtxlab.crypto.channel.service;

import com.vtxlab.crypto.channel.exception.ApiException;
import com.vtxlab.crypto.channel.model.Channel;

public interface AdminService {
  
  Channel getChannelBySourceAppAndTranType(String sourceApp,String tranType) throws ApiException;
}
