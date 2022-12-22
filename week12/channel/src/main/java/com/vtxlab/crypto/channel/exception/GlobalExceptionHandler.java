package com.vtxlab.crypto.channel.exception;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.crypto.channel.response.ApiResponse;
import com.vtxlab.crypto.channel.response.ResponseData;
import com.vtxlab.crypto.channel.response.enums.ResponseStatus;


@ControllerAdvice // Spring bean
public class GlobalExceptionHandler {

  @ExceptionHandler({ ApiException.class })
  /// @org.springframework.web.bind.annotation.ResponseStatus(code =
  /// HttpStatus.bad)
  public ResponseEntity<ApiResponse<? extends ResponseData>> handleApiException(
      ApiException e) {

    //ChannelApi.setAlerts(new Alert(e.getCode(), e.getMessage()));

    return ResponseEntity.badRequest()
        .body(
            new ApiResponse<>(ResponseStatus.INTERNAL_API_FAIL.getCode(),
                ResponseStatus.INTERNAL_API_FAIL.getMessage(), //
                new ResponseData(),
                new ArrayList<>()));
  }

  @ExceptionHandler({ NullPointerException.class, ArithmeticException.class })
  public ResponseEntity<ApiResponse<? extends ResponseData>> handleRuntimeException(
      RuntimeException e) {
    Integer code = null;
    String message = "";
    if (e instanceof NullPointerException) {
      code = ResponseStatus.NPE.getCode();
      message = ResponseStatus.NPE.getMessage();
    } else if (e instanceof ArithmeticException) {
      code = ResponseStatus.AME.getCode();
      message = ResponseStatus.AME.getMessage();
    }
    return ResponseEntity.badRequest().body(
        new ApiResponse<>(code,
            message, //
            null,
            new ArrayList<>()));
  }

  /*
   * @ExceptionHandler({ NullPointerException.class })
   * public ResponseEntity<ApiResponse<T>> handleNpeException() {
   * return ResponseEntity.badRequest().body(new ApiResponse<>(13002,
   * "NPE, sorry", null));
   * }
   * 
   * @ExceptionHandler({ KeyNotFoundException.class })
   * public ResponseEntity<ApiResponse<T>> handleKeyNotFoundException() {
   * return ResponseEntity.badRequest().body(new ApiResponse<>(13003,
   * "Key Not Found Exception, please check", null));
   * }
   * 
   * @ExceptionHandler({ IllegalArgumentException.class })
   * public ResponseEntity<ApiResponse<T>> handleIaeException() {
   * return ResponseEntity.badRequest().body(new ApiResponse<>(13004,
   * "IA Exception, sorry", null));
   * }
   */

}
