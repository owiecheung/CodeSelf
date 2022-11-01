package com.vtxlab.app;

import java.util.ArrayList;
import java.util.List;

import com.vtxlab.infra.Foundation;
import com.vtxlab.model.Customer;

class HelloWorld{
  public static void main(String[] args) {
    System.out.println("hello world");
    
    Customer customer = new Customer();
    customer.setName("O");

    System.out.println(customer.getName() + " HelloWorld");


    //Lambda
    List<Customer> customers = new ArrayList<>();

    customers.add(new Customer());
    customers.add(new Customer());

    for(Customer c : customers){
      System.out.println(c.getName());  //loop 2 times
    }

    //forEach method by Lambda 
    customers.forEach(abc -> System.out.println(abc.getName()));    // = line 27 - 29

      StringBuilder sb = new StringBuilder("Start");
      System.out.println( sb.append("class").toString());


  //  List<Integer> arr = new ArrayList<>(arr);
      
    Foundation.println("2344");
  }
}
