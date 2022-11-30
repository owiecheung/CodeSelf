package com.vtxlab.demo2.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/p1/v1")
public class Project1Controller {
  
  
  @GetMapping(value = "/sum/{integer1}/{integer2}")
  public Integer sum(
    @PathVariable Integer integer1,
    @PathVariable Integer integer2){
      return integer1 + integer2;
    }

}
