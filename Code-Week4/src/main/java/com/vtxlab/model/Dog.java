package com.vtxlab.model;

public class Dog extends Animals {

  public Dog(Size size, Color color){
    super(size, size, color);
  }


  @Override
  public void run(){
    System.out.println("[Dog] Runing");
  }

  @Override
  public void eat(){
    System.out.println("[Dog] Eatting");
  }
}
