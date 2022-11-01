package com.vtxlab.model;

import com.vtxlab.interfaces.Eat;
import com.vtxlab.interfaces.Runner;

public class Animals implements Runner , Eat{

  private Size weight;
  private Size height;
  private Color color;

  public Animals(){}

  public Animals(Size weight, Size height, Color color){
    this.weight = weight;
    this.height = height;
    this.color = color;
  }

  //setter
  public void setAnimalsHeight(Size height){
    this.height = height;
  }
  public void setAnimalsWeight(Size weight){
    this.weight = weight;
  }
  public void setAnimalsColor(Color color){
    this.color = color;
  }

  //getter
  public Size getAnimalsHeight(){
    return this.height;
  }
  public Size getAnimalsWeight(){
    return this.weight;
  }
  public Color getAnimalsColor(){
    return this.color;
  }

  @Override
  public void run(){
    System.out.println("[Animals] Runing");
  }

  @Override
  public void eat(){
    System.out.println("[Animals] Eatting");
  }

}
