package com.vtxlab.model.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape implements Area {

  public int radius;

  public double area() {
    return this.radius * this.radius * 3.14;
  }


}
