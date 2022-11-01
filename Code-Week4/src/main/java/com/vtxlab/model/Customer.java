package com.vtxlab.model;

//com.vtxlab.model.Customer

public class Customer {
  
 private String name;   //package private     in same foloder can use

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name=name;
  }
}
