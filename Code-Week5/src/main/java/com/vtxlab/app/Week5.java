package com.vtxlab.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.vtxlab.model.customer.Customer;
import com.vtxlab.model.customer.SortByCsId;
import com.vtxlab.model.customer.SortByCsName;
import com.vtxlab.model.product.Product;
import com.vtxlab.model.product.SortByPdColor;
import com.vtxlab.model.product.SortByPdId;
import com.vtxlab.model.product.SortByPdName;
import com.vtxlab.model.product.SortByPdSize;


public class Week5 {

  public static void main(String[] args) {

    System.out.println("Helo World");

    Customer customer = new Customer();

    customer.setName("OOw");
    System.out.println(customer.toString());

    // Chapter 4
    Customer customer1 = new Customer(11, "Alex", LocalDate.of(2022, 1, 1));
    Customer customer2 = new Customer(20, "Benny", LocalDate.of(2022, 1, 15));
    Customer customer3 = new Customer(19, "Carl", LocalDate.of(2021, 12, 31));
    Customer customer4 = new Customer(25, "Goe", LocalDate.of(2021, 11, 18));
    Customer customer5 = new Customer(42, "Feve", LocalDate.of(2021, 01, 01));
    Customer customer6 = new Customer(23, "Bec", LocalDate.of(2021, 10, 03));
    List<Customer> customers = new ArrayList<>();
    customers.add(customer3);
    customers.add(customer2);
    customers.add(customer1);
    customers.add(customer4);
    customers.add(customer5);
    customers.add(customer6);

    System.out.println("Comparable : ");
    System.out.println("\nBefore Sorting : \n" + customers);
    Collections.sort(customers);// Compilation error , if class Customer does not implement Comparable
    System.out.println("\nAfter Soring \n" + customers);



    // Comparator
    System.out.println("Comparator : ");
    System.out.println("\nBefore Sorting : \n" + customers);

    int typeCs = 2;

    Collections.sort(customers, getCsSorting(typeCs));

    System.out.println("\nAfter Soring : \n" + customers);

    //Lambda
    Comparator<Customer> sortByName = (s1,s2) -> s1.getName().compareTo(s2.getName());
    Comparator<Customer> sortById = (s1,s2) -> Integer.compare(s1.getId(),s2.getId());
    Comparator<Customer> sortByJoinDate = (s1,s2) -> s1.getJoinDate().compareTo(s2.getJoinDate());

    Collections.sort(customers,sortById.thenComparing(sortByJoinDate).thenComparing(sortByName));
    System.out.println("\nLambda :" + customers +"\n");

    Collections.reverse(customers);
    System.out.println("After reverse List :" + customers);

    //Product
    Product product1 = new Product(1, "ABC", 28,"BLACK");
    Product product2 = new Product(4, "LLcw", 10,"YELLOW");
    Product product3 = new Product(9, "Vse", 33,"WHITE");
    Product product4 = new Product(14, "Hrcer", 42,"BLUE");
   // Product product5 = new Product(typeCs, null, typeCs, null)

    List<Product> products = new ArrayList<>();

    products.add(product1);
    products.add(product2);
    products.add(product3);
    products.add(product4);

    Comparator<Product> sortByColor = (p1,p2) -> {
      
    if("YELLOW".equals(p2.getColor()) && !"YELLOW".equals(p1.getColor()))
      return 1; //  1 -> swap
    if ("YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor()))
      return 0 ;
    if(!"YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor()))
      return -1;
    
    return p1.getColor().compareTo(p2.getColor()); //ascending
    };

    Comparator<Product> sortByPdName = (s1,s2) -> s1.getProductName().compareTo(s2.getProductName());

    System.out.println("Before Sort By Color :" + products);
    Collections.sort(products,sortByColor);
    System.out.println("\nSort By Color :" + products);
    Collections.sort(products,sortByPdName);
    //Comparable
    System.out.println("Comparable : ");
    System.out.println("\nBefore Sorting : \n" + products);
    Collections.sort(products);// Compilation error , if class Customer does not implement Comparable
    System.out.println("\nAfter Soring \n" + products);

    //Comparator 
    System.out.println("\nComparator : ");
    System.out.println("\nBefore Sorting : \n" + products);
    
    //Scanner sorting type
    System.out.println("Please input sort type: \n1. Size \n2. Id \n3. Name \n4. Color");
    Scanner input = new Scanner(System.in);
    int typePd = input.nextInt();


    if(typePd <= 4){
    System.out.println("\nYou have choose : " + typePd );
    Collections.sort(products, getPdSorting(typePd));
    System.out.println(products);
    input.close();
    }
  }




  //Medthod getSorting
  public static Comparator<Customer> getCsSorting(int typeCs){
    if ( typeCs ==1 ){
      return new SortByCsId();
    }else {
      return new SortByCsName();
    }
  }

  public static Comparator<Product> getPdSorting(int typePd){
    switch  (typePd) {
    case 1:  {
      System.out.println("You have choosen Sort By Size");
      return new SortByPdSize();
        }
    
    case 2:  {
      System.out.println("You have choosen Sort By Id");
      return new SortByPdId();
    }
  
    case 3:  {
      System.out.println("You have choosen Sort By Name");
      return new SortByPdName();
    }
    case 4: {
      System.out.println("You have choosen Sort By Color");
      return new SortByPdColor();
    }
    default : {
      System.out.println("Error Type");
      break;
    }
   }
    return null;
  }
}
