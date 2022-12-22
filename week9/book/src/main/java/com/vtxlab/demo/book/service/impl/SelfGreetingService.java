package com.vtxlab.demo.book.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.service.GreetingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SelfGreetingService implements GreetingService{
  

  @Value("${rest.greeting.baseUrl}")
  String baseUrl;

  @Value("${rest.greeting.serviceVers}")
  String serviceVers;

  @Value("${rest.greeting.serviceUrl}")
  String serviceUrl;


  @Override
  public String getGreetingMessage(){
    // return "hello World";
    //Call another service to get result


    String url = UriComponentsBuilder.fromUriString(baseUrl)
                .pathSegment(serviceVers)
                .path(serviceUrl)
                .build()
              //  .encode()
                .toString();

    log.info("url = {} ", url);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, String.class);
  }

  @Override 
  public Book findBookById(Long id){

    String url = UriComponentsBuilder.fromUriString(baseUrl)
       .pathSegment(serviceVers)
       .path(serviceUrl)
       .build()
  //  .encode()
       .toString();

    log.info("url = {} ", url);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, Book.class);

  }

}


