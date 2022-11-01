package com.vtxlab.app;

public class CarOrderException extends Exception{
  public CarOrderException(String msg){
      super(msg);
  }
  
  public CarOrderException(String msg, Throwable e) {
      super(msg,e);
  }


}

