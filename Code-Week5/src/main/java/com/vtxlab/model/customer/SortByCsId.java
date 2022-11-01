package com.vtxlab.model.customer;

import java.util.Comparator;

public class SortByCsId implements Comparator<Customer>{

  @Override
  public int compare(Customer c1, Customer c2) {
   // return c1.getId() < c2.getId() ? -1 : 1; //asending
   return c2.getId() > c1.getId() ? -1 : 1 ;  //desnding
  }
  //basic sorting
}
