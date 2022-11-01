package com.vtxlab.model.product;

import java.util.Comparator;

public class SortByPdSize implements Comparator<Product>{

  @Override
  public int compare(Product p1 , Product p2){
    return p2.getSize() > p1.getSize() ? -1 : 1 ;
  }
  
}
