package com.vtxlab.app.poly;

public class ParentClass {
  public void doSomthing(){
    System.out.println("i am P");
  }


  public static void main(String[] args) {
    ParentClass o1 = new ParentClass();
    ParentClass o2 = new ClassA();
    ParentClass o3 = new ClassB();

    o1.doSomthing();
    o2.doSomthing();
    o3.doSomthing();


    ClassB childB = (ClassB) o3;
 //   ClassB2 childB2 = (ClassB2) childB ; //error ClassCastException
    System.out.println(childB.getName());
//    System.out.println(childB2.getName());

    ParentClass p1 = (ClassB) o3;
    p1.doSomthing();        // i am B   ClassB doSomthing turn back to parentClass 
  }
}
