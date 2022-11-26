package com.vtxlab.demo.student.exception;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class CreateStudentHandler extends Exception{
  private int code;
  private String msg;

  public CreateStudentHandler(int code, String msg) {
    this.msg = msg;
    this.code = code;
  }
}
