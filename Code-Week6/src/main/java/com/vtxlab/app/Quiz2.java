package com.vtxlab.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

interface Animal{
  void eat();
}
public class Quiz2 implements Animal{
  public void eat(){
    System.out.println("QUIZ");
  }

  public void eat(Animal a) {
    a.eat();
  }


}

class Tryagain{
  static byte counter = 5;
  int be = 2;

  public static void main(String[] args) {
    Tryagain q = new Tryagain();

    for (Integer i = 0 ; i<2;i++){
      counter = (byte) ( i+q.be);

    }
    System.out.println(counter);

    LinkedList<String> s = new LinkedList<>();

    for(int i =0; i< 4;i++){
      if(i%2>0){
        s.addLast("N");
      }else{
        s.addLast("C");
      }
    }
    s.addFirst("V");
    s.add("T");
    s.add(4,"E");
    s.set(2, "I");

    System.out.println(s);
  }
}

class AnimalFarm{
  public static void main(String[] args) {
    Animal quiz = new Quiz2();
    quiz.eat();

    Animal small =() -> System.out.println("ANINAD");
    small.eat();

    Quiz2 biz = new Quiz2();
    biz.eat(small);
  }
}

interface Superman{
  void protect(Children child);
}

interface Children {
  void cry();
}

class Q2{
  String n;
  Q2(String n){
    this.n = n;
  }
  public static void main(String[] args) {
    Superman s = x -> x.cry();
    s.protect(() -> System.out.println("12e"));
    List<Q2> a = new ArrayList<>();
    a.add(new Q2("B"));
    a.add(new Q2("C"));


    //Collections.sort(a, new Q2("A"));

    System.out.println( );
  }
}

enum Color{
  RED(1)
  ;

  static int counter =0;
  int value;

  Color(int i){
    this.value = i;
   // counter++;
  }
}

class Q11{
  static int hasCount =0;
  static Map<Integer,An> hasmap = new HashMap<>();

  static class An{
    String name;

    An(String name){
      this.name = name;
      hasCount++;
    }

    String getName(){
      return this.name;
    }
  }

  public static void addAn(An an){
    hasmap.put(hasCount, an);
  }
  public static void main(String[] args) {
    addAn(new An("Yes"));
    addAn(new An("No"));
    addAn(new An("Yes"));
    addAn(new An("4"));

    System.out.println(hasmap);

    hasmap.remove(3);
    System.out.println(hasmap.get(3).getName());
  }
}

class Car{

  int sp = 100;
  static Car inst = new Car();

  private Car(){}

  public static Car getInst(){
    return inst;
  }

  public void setsp(int s){
    this.sp =s;
  }
}

class Q12{
  public static void main(String[] args) {
    Deque<Car> d = new LinkedList<>();
    Car tes = Car.getInst();
    Car toy = Car.getInst();

    tes.setsp(80);
    d.add(tes);
    d.push(toy);

    System.out.println(d.getLast().sp +" " +d.getFirst().sp);
  }
}

class Cust extends RuntimeException{

  public Cust(){
  }

  public Cust(String msg,Throwable e){
    super(msg,e);
  }

  public static int test() {
    throw new Cust();
  }

  public static void main(String[] args) {
    test();
  }
}

class Person{

  private String fn;

  private Person(){}

  public Optional<String> getfn(){
    return Optional.ofNullable(fn);
  }

  public static Optional<Person> getIns(){
    return 4% 2==0 ? Optional.of(new Person()) : Optional.empty();
  }
}

class Q15{
  public static void main(String[] args) {
    Person.getIns().ifPresent(p -> {
      System.out.println("Yes");
      p.getfn().ifPresent(n -> System.out.println(n));
    });
  }
}

class Data{
  private String[] s;

  Data(String[] s){
    this.s = s;
  }

  public String[] gets(){
    return this.s;
  }
}

class Q1{

  public static void main(String[] args) {
    Data p1 = new Data(new String[]{"ABC","BCD"});
    Data p2 =p1;
    Data p3 =new Data(new String[]{"ABC","BCD"});
    String s1 ="ABC";
    String s2 = "ABC";

    System.out.println(p1 ==p2);
    System.out.println(p2 ==p3);
    System.out.println(s1==s2);
    System.out.println(s1.equals(p1.gets()[1]));
    System.out.println(s2.equals(s1));
  }
}
/* 
1.D
2.A
3.A
4.E
5.E
6.A
7.B
8.A
9.E
10.B
11.C
12.E
13.E
14.D
15.C
16.D
17.A
18.D

ANS : DABEEABAADCEECCDAB
MY  : DAAEEABAEBCEEDCDAD 
      VVXVVVVVXXVVVXVVVX
*/