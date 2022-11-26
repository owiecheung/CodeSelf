package com.vtxlab.demo.book.exception;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class KeyNotFoundExistException extends Exception {

  private int code;

  public KeyNotFoundExistException(int code, String msg) {
    super(msg);
    this.code = code;
  }
}