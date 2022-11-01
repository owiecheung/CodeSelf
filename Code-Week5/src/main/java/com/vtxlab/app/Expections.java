package com.vtxlab.app;



public class Expections {
  
  public static void main(String[] args) {
    
    int i = 0;
    int y = 2;


    try{
      y = y/i;
      // m...

    } catch (ArithmeticException e) {
        y =0;
        System.out.println(y);;
    }


    /* 
    try{
      int c = divide(10,0);
    }catch (CustomException e){
      System.out.println("I do nothing");
    }catch(Exception e1) {
      System.out.println("default Exception");
    }
      */                                       
  }

  public static int divide(int a , int b) throws ArithmeticException{
  //  try{
    return a/b;
 // } catch (ArithmeticException e){  // divide by zero
 //   throw new CustomException("I am throwing a CustomException");
//   }
 }
}
