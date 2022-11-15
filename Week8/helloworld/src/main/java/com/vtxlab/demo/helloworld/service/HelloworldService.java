package com.vtxlab.demo.helloworld.service;

import org.springframework.stereotype.Service;


@Service
public class HelloworldService {
  

  public String sayhello(String a){
    return a + " OMG 123";

  }
}
