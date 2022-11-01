package com.vtxlab.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lambda {
  
  public static void main(String[] args) {
    
    

    Map<String,Integer> nameLengthMap = new HashMap<>();

    nameLengthMap.put("Peter", 50);
  //Writing a formla to calculate the length of input"String"
    Function<String, Integer> computeLength = String :: length;  // s -> s.length()

    //1. Check if the key exist
    //2. If no , calculate value according to the forml
    //3. put the key & value (entry) to the map
    Integer computedValue = nameLengthMap.computeIfAbsent("Peter", computeLength);

    System.out.println(computedValue);

    System.out.println(nameLengthMap.get(20));



    //biFunction

    Map<String,Integer> nameFrequencyMap = new HashMap<>();
    nameFrequencyMap.put("Peter", 3);

    //equivalent to {oldValue , newValue} - > oldValue + newValue;
    //BiFunction<Integer,Integer,Integer> megrgeFrequencyByName = Integer :: sum;
    BiFunction<Integer,Integer,Integer> megrgeFrequencyByName = (a,b) -> a + b;
    //return b;  -> turn 

    //1."Peter" is a key to find the value in the map.entry
    //2. Them compute the return value and second paramter arroiding to these formla
    //3. 3 + 4 =7
    //4. Finally update the value to 7 for Key "Peter"
    Integer mergeValue = nameFrequencyMap.merge("Peter", 4, megrgeFrequencyByName);                                                                                                               
    
    System.out.println(mergeValue);
    System.out.println(nameFrequencyMap);
    
    //UnaryOperator and BinaryOperator  一入一出
    UnaryOperator<String> u1 = String::toUpperCase;
    System.out.println(u1.apply("iace"));

    BinaryOperator<String> b1 = String::concat;
    System.out.println(b1.apply("vv", "d"));


    //Supplier Only output not input
    Supplier<Integer> supplyRandomInteger = () -> new Random().nextInt(20) + 1;
    System.out.println(supplyRandomInteger.get());


    List<String> names = Arrays.asList("Peterr","Pauul","Nerbb","Paulgoa");

    //Consumer only Input
    Consumer<String> printname1 = name -> System.out.println("hello :" + name);
    names.forEach(printname1);
    //foreach because of Consumer can loop whole list

    //Lambda Expression 
    names.forEach(element -> {
      System.out.println("Hello :" + names);
      System.out.println("Bye :" + names);
    });

    Map<String,Integer> ages = new HashMap<>();
    ages.put("Petter", 20);
    ages.put("Katte", 24);
    ages.put("Goedce", 21);

    BiConsumer<String,Integer> printname2 = (name,age) -> 
                            System.out.println(name + " is " + age + " years old");
    ages.forEach(printname2);


    //Predicate
    Predicate<String> stratwithP = name -> name.startsWith("P");

    if (stratwithP.test("Petter")){
      System.out.println("Yes");
    }

    List<String> filteredNames = names.stream()
                                      .filter(stratwithP)
                                      .collect(Collectors.toList());
    System.out.println(filteredNames);


    BiPredicate<String,String> stratwithPrefix = (string,prefix) -> string.startsWith(prefix);

    System.out.println(stratwithPrefix.test("Redcg", "Gcvr"));
    System.out.println(stratwithPrefix.test("Lmefew", "Lmefew"));
    System.out.println(stratwithPrefix.test("HelloWWve", "HelloW"));

    //Method References
  List<String> namesList = new ArrayList<>();
  namesList.add("Joe");
  namesList.add("Kikiii");
  namesList.add("Mario");

    List<String> helloNamesList = namesList.stream()
                                      .collect(Collectors.toList());
  }


}

//Supplier    Only give sth out , can't set (eat) anything.
@FunctionalInterface
interface Supplier<T>{
    T get();
}

//Consumer and BiConsumer
@FunctionalInterface 
interface Consumer1<T>{   //Don not return anything 
        void accept(T t);
}

@FunctionalInterface
interface BiConsumer1<T,U>{
        void accept(T t,U u);
}

//Predicate
@FunctionalInterface
interface Predicate1<T>{
    boolean test(T t );
}      

//BiPredicate
@FunctionalInterface
interface BiPredicate1<T,U>{
  boolean test(T t, U u);
}

