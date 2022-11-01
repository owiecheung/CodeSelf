package com.vtxlab.interfaces;

public class MathOperationHolder implements MathOperation {

  @Override
  public int compute(int x, int y) {
    return x + y;
  }

}
