package com.vtxlab.app;

public class CustomRunTimeException extends RuntimeException {

  //Unchecked Exception
  public CustomRunTimeException(String s){ // extends also needs to create a new constructor
    super(s);
  }
  
}
