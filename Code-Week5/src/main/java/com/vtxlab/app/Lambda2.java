package com.vtxlab.app;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface UnaryOperator1<T> extends Function<T,T>{

}

public class Lambda2 {

  public static void main(String[] args) {

    Function<Integer, String> function1 = (i) -> "abc";

    Function<Integer, int[]> function2 = (a) -> new int[] { 1, 2, 3, 4 };

    Function<Integer, Map<String, String>> function3 = (v) -> new HashMap();

    Function<Integer, int[]> function4 = (b) -> {
      if (b == 4) {
        return new int[] { 1, 2, 3, 4, 5 };
      }
      return new int[] { 2, 4, 6, 8, 10 };
    };

    System.out.println("Function<Integer, String> function1 = (i) -> abc :" + function1.apply(2) + 
                      "\nFunction<Integer, int[]> function2 = (a) -> new int[] { 1, 2, 3, 4 }; :" + function2.apply(3)+
                      "\nFunction<Integer, Map<String, String>> function3 = (v) -> new HashMap(); : " + function3.apply(5) +
                      "\nFunction<Integer, int[]> function4 = (b) ->  " +
                      "\nif (b == 4) { " +
                      "\n  return new int[] { 1, 2, 3, 4, 5 }; } " +
                      "\n return new int[] { 2, 4, 6, 8, 10 };" +
                      "\n}; : " + function4.apply(6));

    Function<Integer, int[]> arrayWithSize = (a) -> new int[a];

    int[] integers = arrayWithSize.apply(6);

    BiFunction<Integer, Integer , Double[]> arrayWithSize2 = (i,n) -> new Double[i + n];
    Double [] arr = arrayWithSize2.apply(7, 8);

    Function<Integer, Integer> randomNumber = (range) -> (int) (Math.random() * range);
    System.out.println(randomNumber.apply(20));

    Function<Long, LocalDate> nextWeek = (days) -> LocalDate.now().plusDays(days);
    System.out.println(nextWeek.apply(2l));

    Supplier<LocalDate> sevenDaysLater = () -> LocalDate.now().plusDays(7);
    System.out.println(sevenDaysLater.get());

    Consumer<Object> number1 = (a) -> {
      if (a instanceof Number){   //check if a is a child class of Number
        System.out.println(a.toString());
       System.out.println(((Number)a).intValue());
      }
    };

    number1.accept(99);

    //UnaryOperation     is extends Function
    //if and only if the implemetion can be completed in one line
    //lskip bracket and return keyword
    UnaryOperator<String> string = x -> x.toLowerCase();
    UnaryOperator<String> string2 = x -> x.toUpperCase();
    UnaryOperator<String> replaceC_By_A = x -> x.replace('c', 'a');

   String s = string2.apply("cccccc");
   String new_s = replaceC_By_A.apply(s);
   System.out.println(new_s);


   BinaryOperator<int[]> megreIntArray = (x,y) -> {
    int [] z = new int[x.length + y.length];
    for(int i =0 ; i < x.length; i++){

      z[i] = x[i];
    }
    for(int j = 0; j< y.length; j++){
      z[x.length+j] = y[j];
    }
    return z;
   };

   int [] new_Array = megreIntArray.apply(new int []{1,5,7,0,3,0,33,0}, new int[]{55,0,45});
   //Arrays.sort(new_Array);
   //List<Integer> list = new ArrayList<>(Arrays.asList(new_Array));

   //Count how many 0 of new_Array currently has
   int count = 0;
   for(int i = 0; i < new_Array.length ; i++){
    if(new_Array[i] == 0){
      count++;
    }
   }

   int [] o = new int [new_Array.length-count];
   int c = 0;
   for( int i = 0 ; i < new_Array.length; i++){
    if (new_Array[i] != 0){
      o[c] = new_Array[i];
      c++;
    }
   } 
   Arrays.sort(o);

   System.out.println(Arrays.toString(new_Array));
   System.out.println(Arrays.toString(o));



   //Predicate
   Predicate<String> lengthSmallerThanFive = x -> x.length() < 5;
   System.out.println(lengthSmallerThanFive.test("abcd1")); //false
   System.out.println(lengthSmallerThanFive.test("avb")); //true


  BiPredicate<String,String> compareHash = (x,y) -> x.hashCode() ==y.hashCode();
System.out.println(compareHash.test("abc", "abc")); //true
System.out.println(compareHash.test("abc", "abcd")); //false

  String s10 = "abcd";
  System.out.println(s10.hashCode());

  String s9 = ""; //it is blank and empty
  String s8 = "null";
  String s7 = "null ";
  String s6 = "  ";
  String s5 = null;

  //s9
  if( !Objects.isNull(s9)){
   System.out.println("s9 is blank : " + s9.isBlank()); //true
   System.out.println("s9 is Empty : " + s9.isEmpty()); //true
  }
   //s8
   if( !Objects.isNull(s8)){
   System.out.println("s8 is blank : " + s8.isBlank()); //false
   System.out.println("s8 is Empty : " + s8.isEmpty()); //false
   }
   //s7
   if( !Objects.isNull(s7)){
   System.out.println("s7 is blank : " + s7.isBlank()); //false
   System.out.println("s7 is Empty : " + s7.isEmpty()); //false
   }
   //s6
   if( !Objects.isNull(s6)){
   System.out.println("s6 is blank : " + s6.isBlank()); //true
   System.out.println("s6 is Empty : " + s6.isEmpty()); //false
   }

   //s5
   if( !Objects.isNull(s5)){
   System.out.println("s5 is blank : " + s5.isBlank()); //true
   System.out.println("s5 is Empty : " + s5.isEmpty()); //false
   }else{
    System.err.println("s5 is null"); 
   }




  }

}
