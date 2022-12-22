package com.vtxlab.demo.weather.response;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
  
  private Integer code;

  private String message;

  //Able to map any type , but not primitive
  private T data;

  //includes warining and error
  private List<Alert> alerts;
}
