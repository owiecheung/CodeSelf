package com.vtxlab.model.product;

import java.util.Comparator;

public class SortByPdId implements Comparator<Product>{

  @Override
  public int compare(Product p1, Product p2){

    return p1.getProductId() < p2.getProductId() ? -1 : 1;
  }
  
}
