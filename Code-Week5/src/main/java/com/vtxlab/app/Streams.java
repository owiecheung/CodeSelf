package com.vtxlab.app;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class Streams {
    public static void main(String[] args) {
    
  List<String> names = Arrays.asList("Peter","Carllla","Benny","Alex","Lleub");

  Predicate<String> containC = e -> e.contains("C");
  Predicate<String> containB = e -> e.contains("B");
  Predicate<String> lengthLessThanFive = e -> e.length() < 5;

  Function<String,String> returnSelf = e -> e;
  Function<String,String> toUpperCase = e -> e.toUpperCase();
  Function<String,String> toSubstring = e -> e.substring(0, 3);


  //filtering
    Set<String> filteredNames1 = names.stream()
         .map(toUpperCase.andThen(toSubstring))
         .filter(containB.and(lengthLessThanFive)) //Intermediate operation
         .collect(Collectors.toSet());

    Set<String> removeDuplicated = names.stream().collect(Collectors.toSet());
    System.out.println(removeDuplicated);

  List<String> filteredNames = names.stream()
                    .map(name-> {
                      //if then else
                      return name + "A";
                    })
                    .filter(containC.and(lengthLessThanFive)) //Intermediate operation
                    .collect(Collectors.toList());

    System.out.println(filteredNames1);
   //System.out.println(filteredNames1);
    
   //Stream Literate
   List<Integer> numbers =  Stream.iterate( 1, n -> n+1)
                      .limit(10)
                      .collect(Collectors.toList());

    System.out.println(numbers);

    Integer reduced = numbers.stream()
                    .reduce(0, (a,b) -> a - b);
    System.out.println(reduced);

    List<Integer> numberList = Arrays.asList(999,222,102,245,424);
    Optional<Integer> optional1 =numberList.stream()
                      .min((o1,o2) -> o1.compareTo(o2));

   optional1.ifPresent(System.out::println);

   long streamCount = Stream.of(1,2,3,4).map(i -> {
        System.out.println(i); 
        return i;
      }).count();

      System.out.println(streamCount);
  }
}
