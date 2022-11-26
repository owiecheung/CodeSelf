package com.vtxlab.demo.book.exception;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class KeyExistException extends Exception {

  private int code;

  public KeyExistException(int code, String msg) {
    super(msg);
    this.code = code;
  }
}