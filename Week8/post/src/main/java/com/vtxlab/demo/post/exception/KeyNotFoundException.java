package com.vtxlab.demo.post.exception;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor


public class KeyNotFoundException extends RuntimeException {

  private int code;

  public KeyNotFoundException(int code, String msg) {
    super(msg);
    this.code = code;
  }
}