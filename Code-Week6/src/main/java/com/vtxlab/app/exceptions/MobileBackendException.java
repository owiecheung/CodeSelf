package com.vtxlab.app.exceptions;

import com.vtxlab.app.enums.Exceptions;

public class MobileBackendException extends BusinessException{
  
  private int code;

  private MobileBackendException(){
    super();
  }

  private MobileBackendException(String s){
    super(s);
  }

  private MobileBackendException(String s,Throwable e){     
    super(s, e);
  }

  private MobileBackendException(int code, String s){
    this(code + " : " + s); // refer public MobileBackendException(String s)
    this.code = code;
  }

  private MobileBackendException(int code, String s, Throwable e){
    this(code + " : " + s , e); // refer public MobileBackendException(String s)
    this.code = code;
  }

  public MobileBackendException(Exceptions enums){    //import enums
    this(enums.getCode(),enums.getexceptionMsg());
  }

  public MobileBackendException(Exceptions enums,Throwable e){    //import enums
    this(enums.getCode(),enums.getexceptionMsg(), e);
  }


}
