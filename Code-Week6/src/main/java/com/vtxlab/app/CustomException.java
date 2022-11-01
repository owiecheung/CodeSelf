package com.vtxlab.app;

import java.util.List;

public class CustomException extends RuntimeException {

  private String anotherMsg;

  public String aothermsge;

  public CustomException(String msg) {
    super(msg);

  }
  public CustomException(String msg, List<String>strings){
    super(msg);
    String s;
    strings.forEach(r -> this.anotherMsg += r);
  }


  public static void test2(){
    throw new CustomRunTimeException("gg");
  }

  public static void main(String[] args) throws Exception{
    test2();//error
    
  }
}

//Checked Exception need to throw接 need try catch
//Unchecked Exception can just throw 

