package com.vtxlab.app;

import com.vtxlab.model.generics.Circle;
import com.vtxlab.model.generics.Customer;
import com.vtxlab.model.generics.IntegerHolder;
import com.vtxlab.model.generics.Shape;

public class Generics {

  public static void main(String[] args) {
    
    IntegerHolder intHolder = new IntegerHolder();

    intHolder.setI(101);
    System.out.println(intHolder.getI());

    Customer customer = new Customer<>();
    customer.setAge(234);
    //System.out.println(customer.getAge().equals("123")); //Compile cannot define the age as String

  //  String s = (String) customer.getAge(); // customer.getAge(); as Object only

    Customer<Integer> customer2 = new Customer<>(); //Just need to Delcare it as Integer or String
    customer2.setAge(66);
    System.out.println(customer2.getAge());

    Customer<Double> customer3 = new Customer<>();
    customer3.setAge(37.0);
    customer3.setAge(42d);
    System.err.println(customer3.getAge());

    Customer<Float> customer4 = new Customer<>();
    customer4.setAge(37.0f); //Java compiler default 12.0 s double
    customer4.setAge(42f);
    System.out.println(customer4.getAge());

    System.out.println(Customer.calcAge(Integer.valueOf(4)));
    System.out.println(Customer.calcAge("123"));





    //Shape

    Circle cicrle = new Circle();
    cicrle.setRadius(3);
    
    System.out.println("\nCircle Area :\n" + Shape.calcArea(new Circle(2))); //same

    System.out.println(cicrle.area()); //same



    Shape.calcArea(new Circle(3));
  }
}
