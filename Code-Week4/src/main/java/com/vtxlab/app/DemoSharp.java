package com.vtxlab.app;
abstract class Shape{

  abstract double cm2();
}

class Circle extends Shape{

  int r;

  double cm2(){
    return this.r * this.r * 3.14;
  }
}



interface Shape2{

  double cm2();
}

class Circle2 implements Shape2{

  int t;

  public double cm2(){
    return this.t * this.t *3.14;

  }
}

