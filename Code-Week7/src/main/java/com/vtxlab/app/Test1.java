package com.vtxlab.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test1{

  private int a;

  public Test1(){}
  public Test1(int a){
    this.a = a;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

public static void main(String[] args) {
  Test1 b = new Test1(10);
  System.out.println(b.a);
  Test1 c = new Test1();
  c.setA(4);
  System.out.println(c.a);
  
  Map<Integer,String> map1 = new HashMap<>();

  map1.put(1, "1");
  map1.put(2, "2");
  map1.put(3, "3");
  map1.put(2, "5");


  System.out.println(map1.toString());

  Set<Integer> set1 = new HashSet<>();
  set1.add(4);
  set1.add(5);
  set1.add(6);
  set1.add(4);
  System.out.println(set1.toString());

  Integer[] intarray = {1,2,4,6};
  List<Integer> integers = Test1.fromArrayToList(intarray);
  Test1.listCount(integers);
  System.out.println(integers);

 }
 public static <T> List<T> fromArrayToList(T[] a){
    return Arrays.stream(a).collect(Collectors.toList());
 }

 public static <T> long listCount(List<T> a){
  return a.stream().count();
 }


}