package com.vtxlab.app;

import java.util.Scanner;

import com.vtxlab.infra.Foundation;
import com.vtxlab.interfaces.MathOperation;
import com.vtxlab.model.Printer;

public class MathOperationTest {


  //private static int calculate(int x , int y, MathOperation f){
    //return f.compute(x, y);
  //}

  public static void main(String[] args) {
    

      Scanner input = new Scanner(System.in);
      System.out.print("Input x : ");
      int input1 = input.nextInt();
      System.out.print("Input y : ");
      int input2 = input.nextInt();
      
      MathOperation additionOperation = ( x, y) -> x + y;
      MathOperation subtractOperation = ( x, y) -> x - y;
      MathOperation multipleOperation = ( x, y) -> x * y;
      MathOperation divideOperation = ( x, y) -> x / y;
      
      MathOperation addMathOperation2 = ( x , y) -> {
        int z =100 ;
        return z * x - y;
      };

        MathOperation noLambda = new MathOperation() {
          @Override
          public int compute(int x , int y){
            return x+ y;
          }
        };

       System.out.println(additionOperation.compute(input1, input2));
       System.out.println(subtractOperation.compute(input1, input2));
       System.out.println(multipleOperation.compute(input1, input2));
     //  System.out.println(divideOperation.compute(input1, input2));


    //   MathCalculator mathCalculator = s -> System.out.println("vvv" + s);
  //    mathCalculator.print();

       Foundation.println("abc");

       Printer<String> printer =  new Printer<>(" Hi i am calculator");
       printer.print();
       
  }
}
