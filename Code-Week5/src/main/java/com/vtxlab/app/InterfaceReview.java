package com.vtxlab.app;



@FunctionalInterface
interface Sum{
  double sum(int a, int b);
}

@FunctionalInterface
interface String1{
  String c(int n);
}



public class InterfaceReview {
  public static void main(String[] args) {
    
    Sum sum = (a,b) -> { //more than 1 line , need to have a return keywords
      double c = a+b;
      return c/2;
    };

    Sum sum2 = (a,b) -> (a + b) /2 ;   //No return keywords

    
    System.out.println(sum.sum(5, 6));
    System.out.println(sum2.sum(3, 1));


 String1 c =  n -> {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for ( int i = 0 ; i < n ; i ++ ){
        sb.append(i);
        if( i < n -1 ){
          sb.append(", ");
        }
      }

      sb.append("]");
      return sb.toString();
    };
    System.out.println(c.c(6));
  }
}
