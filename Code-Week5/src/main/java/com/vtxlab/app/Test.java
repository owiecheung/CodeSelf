package com.vtxlab.app;


public class Test {
  public static int calculate(int x){   //Pass by value 
    x = x+1;
    return x;
  }

  public static Integer calculate(Integer x){  //this is also Warrper class
    x = x+1;
    return x;
  }

  public static StringBuilder calculate(StringBuilder x){  // this is non warrper class
    x.append("Pass By Reference");  // will change the reference
    return x;                       //and pass back to main programme
  }

  public static void main(String[] args) {
    int x =2;
    //before pass by value
    System.out.println(x);

    calculate(x);
    //After pass by value
    System.out.println(x);  // would not change

    Integer r  = 3;   // Integer as Warper class
        //before pass by value
        System.out.println(r);

        calculate(r);
        //After pass by value
        System.out.println(r);  // would not change   //same as int 



    StringBuilder o = new StringBuilder("w");
    //before pass by reference
    System.out.println(o);

    //After pass by reference
    calculate(o);
    System.out.println(o.toString());


  }
}
