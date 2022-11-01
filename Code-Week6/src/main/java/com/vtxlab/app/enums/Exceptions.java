package com.vtxlab.app.enums;

public enum Exceptions { // package need to public
  
  //Timeout Exception 
  TIMEOUT(1000,"Exception - Time out !"),
  CUSTOMER_WEBSITE_TIMEOUT(1001,"Exception - Customer Website Time out !"),

  //Duplicated Record
  DUPLICATED_RECORD(2000,"Exception - Duplicated Record !"),

  //Bad Gateway
  BAD_GATEWAY(3000,"Exception - Bad Gateway!"),

  //Token Expire
  TOKEN_EXPIRE(4000,"Exception - Token Expire !"),

  //NPE
  NPE(5000, "Runtime Exception - NPE")
  ;

  private int code;
  private String exceptionMsg;

   private Exceptions(int code,String exceptionMsg){
    this.code = code;
    this.exceptionMsg = exceptionMsg;
  }

  //getter
  public int getCode(){
    return this.code;
  }

  public String getexceptionMsg(){
    return this.exceptionMsg;
  }


}
