package com.vtxlab.model;

public class Size {
  
  private double weight;
  private double height;

  public Size(){}

  public Size(double weight, double height){
    this.weight = weight;
    this.height = height;
  }

  //setter
  public void setWeight(double weight){
    this.weight = weight;
  }
  public void setHeight(double height){
    this.height = height;
  }


  //getter
  public double getWeightKg(){
    return this.weight;
  }
  public double getWeightLb(){
    return this.weight * 2.20462262;
  }

  public double getHeightInCm(){
    return this.height;
  }

  public double getHeightInM(){
    return this.height / 100;
  }

}
