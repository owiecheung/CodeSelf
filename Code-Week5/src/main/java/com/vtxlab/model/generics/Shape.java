package com.vtxlab.model.generics;

public abstract class Shape{
  

    public String color;

    public  static <T extends Shape & Area> double calcArea(T t){  // ensure there was calculate method so that need to extends Area
      //Sahpe ->color
      
      return t.area();
    }

    public static double calcArea2(Area s){ //only one praent class
      return s.area();
    }

}
