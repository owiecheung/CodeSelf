package com.vtxlab.demo.helloworld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//This is Business logic
@Service
public class HelloworldService {
  
  private static final List<String> strings = new ArrayList<>();

  @Value("${string-length.max.helloworld}")
  private Integer strMaxlengthForHW;

  @Value("${string-length.min.helloworld}")
  private Integer strMinlengthForHW;




  public String sayhello(String a){
    if(a.length() > strMaxlengthForHW){
      return "Exceed max length";
    }
    if(a.length() < strMinlengthForHW){
      return "Below min length";
    }
    return a + " OMG 123";

  }

  public Boolean createString(String name){
    return strings.add(name);
  }

  public List<String> getAllString() {
    return HelloworldService.strings;
  }

  public Boolean delete(String name){
    return strings.remove(name);
  }
   

  public Boolean deleteAll(){
     return strings.size() == 0? true : strings.removeAll(strings);
  }

  public String deleteLast(){
    return strings.remove(strings.size() -1 );   //delete by index
  }

  public List<String> updateString(List<String> stringsList){
    if(this.deleteAll()){
    stringsList.forEach(e -> {
      strings.add(e);
      });
      return strings;
    } 
    return strings;
  }

  public String updateFirst(String element){

    if (strings.size() == 0){
      strings.add(element);
    }
     strings.set(0, element);
     return element;

  }

}
