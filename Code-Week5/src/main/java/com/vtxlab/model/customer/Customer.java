package com.vtxlab.model.customer;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//Anotation
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Customer implements Comparable <Customer> {


  private int id;

  private String name;

  private LocalDate joinDate;

  @Override
  public int compareTo(Customer o){
    return Integer.compare(o.getId(), this.id); //asending order
    //return o.getIF < i ? -1 : 1;  // dsending order
    //return this.id < o.getId() ? -1 : 1 ;//desending order  
    //return this.name.compareTo(o.getName());  //descending order

 
}
}