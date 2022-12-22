package com.vtxlab.demo.weather.response.enums;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    //code
    //messge

    //Success
    OK(20000,"Success."),
    //20001 ..
    //Fail
    FAIL(30000,"Fail."),
    //30001 ...
    THIRD_PARTY_API_FAIL(30001,"Third Party Api Fail."),
    THIRD_PARTY_API_TIMEOUT(30002,"Third Party Api Timeout."),
    NPE(70000, "Nullpointer Exception.");


    Integer code;
    String message;

    ResponseStatus(int code,String message){
      this.code = code;
      this.message = message;
    }
}
