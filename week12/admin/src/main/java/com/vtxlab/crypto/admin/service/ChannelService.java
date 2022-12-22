package com.vtxlab.crypto.admin.service;

import java.util.List;
import java.util.UUID;

import com.vtxlab.crypto.admin.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType);

  List<Channel> getAllChannel();

  Channel updateChannel(Channel channel, Long id);


  void deleteAllChannel();

  Channel saveChannel(Channel channel, UUID uuid);

  Channel submitChannel(Channel channel, UUID uuid);

}
