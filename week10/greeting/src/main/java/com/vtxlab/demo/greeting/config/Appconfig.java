package com.vtxlab.demo.greeting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;




@Configuration //One of @Component
/**
 * 
 * @Compoent Scan will scan this @Configuration
 * SpringBoot will look up this class 
 * and auto make this to bean into the spring context
 */
public class Appconfig {
  
  @Bean
  public ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
}
