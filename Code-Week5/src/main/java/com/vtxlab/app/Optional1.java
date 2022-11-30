package com.vtxlab.app;

import java.lang.StackWalker.Option;
import java.util.Optional;

public class Optional1 {
  

  public String get(){
    return "tommmmy ";
  }

  public static Optional<String> getOptionalName(){
    //return Optional.of("Tommmy");
    return Optional.ofNullable(null);
    //return Optional.empty();
  }

  public static void main(String[] args) {
    
    String name = "";
    Optional<String> opt1 = Optional.of(name);
    System.out.println(opt1.isPresent());

    Optional<String> s = getOptionalName();
        // ifPresent -> Consumer (void) Using Lambda
    s.ifPresent(e -> {
      System.out.println(e.length());
    });

    String s2 = s.orElse("Stevee"+"2");
    System.out.println(s2);
    s.ifPresent(e -> {
      System.out.println(s.get()); //another runtime exception
    });
    // need to type ifPresent -> NoSuchElementException

    Optional<String> opt2 = Optional.ofNullable(null);
    String defaultWithOrElse = opt2.orElse("default value"+"3");
    System.out.println(defaultWithOrElse);
    



  }
}
