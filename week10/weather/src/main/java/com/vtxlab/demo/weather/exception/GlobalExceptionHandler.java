package com.vtxlab.demo.weather.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.weather.controller.impl.WeatherController;
import com.vtxlab.demo.weather.response.Alert;
import com.vtxlab.demo.weather.response.ApiResponse;
import com.vtxlab.demo.weather.response.enums.ResponseStatus;


@ControllerAdvice // Spring bean
public class GlobalExceptionHandler<T> {

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiResponse<T>> handleApiException(ApiException e){
      WeatherController.errAlerts.add(new Alert(e.getCode(), e.getMessage()));

      return ResponseEntity.badRequest().body(
        
        new ApiResponse<>(ResponseStatus.THIRD_PARTY_API_TIMEOUT.getCode(),
            ResponseStatus.THIRD_PARTY_API_TIMEOUT.getMessage(),
            null,
            WeatherController.errAlerts));
    }


  @ExceptionHandler({ NullPointerException.class })
  public ResponseEntity<ApiResponse<T>> handleNpeException() {
    return ResponseEntity.badRequest().body(
        new ApiResponse<>(ResponseStatus.NPE.getCode(),
            ResponseStatus.NPE.getMessage(), //
            null,
            WeatherController.errAlerts));
  }

  // @ExceptionHandler({ KeyExistException.class })
  // public ResponseEntity<ApiResponse<T>> handleKeyExistException() {

  //   return ResponseEntity.badRequest().body( new ApiResponse<>(13001,
  //   "key already exists",null));
  // }


  // @ExceptionHandler({ KeyNotFoundException.class })
  // public ResponseEntity<ApiResponse<T>> handleKNFException() {

  //   return ResponseEntity.badRequest().body( new ApiResponse<>(13003,
  //   "Can not found the Key.",null));
  // }



  
}