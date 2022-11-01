package com.vtxlab.model;

import com.vtxlab.interfaces.Eat;
import com.vtxlab.interfaces.Runner;

public class Cat extends Animals implements Runner,Eat {

  public Cat(Size size,Color color){
    super(size,size,color);
  }



  @Override
  public void run(){
    System.out.println("[Cat] Runing");
  }

  @Override
  public void eat(){
    System.out.println("[Cat] Eatting");
  }  
}
