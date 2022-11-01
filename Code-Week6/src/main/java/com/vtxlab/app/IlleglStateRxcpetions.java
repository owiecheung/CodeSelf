package com.vtxlab.app;

import java.io.*;

import com.vtxlab.app.enums.Exceptions;
import com.vtxlab.app.exceptions.MobileBackendException;

public class IlleglStateRxcpetions {
  public static void print(int a , int b) {
    System.out.println("addition of postive Integers : " + (a+b));

  }

  public static void printAddition(int x , int y ){

    if(x >= 0 && y >= 0){
      IlleglStateRxcpetions.print(x, y);
    }else{
      throw new IllegalStateException("Either one or two numbers are not postive");
    }
  }

  public static void main(String[] args) throws MobileBackendException {


    
    try{
      printAddition(-1, -3);
    }catch (IllegalStateException e){
      printAddition(1, 3);
    }

    String s =null;

    try{
      int l = s.length();
    }catch (NullPointerException e){
      throw new MobileBackendException(Exceptions.NPE);
    }
    
    
  }
}
