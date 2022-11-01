package com.vtxlab.model;

public class Printer <T>{

  T someThing;

  public Printer(T someThing){
    this.someThing = someThing;
  }

  public void print(){
    System.out.println(someThing);
  }
}
