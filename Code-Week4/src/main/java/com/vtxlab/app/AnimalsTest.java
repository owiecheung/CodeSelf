package com.vtxlab.app;

import java.util.Scanner;

import com.vtxlab.model.Animals;
import com.vtxlab.model.Dog;
import com.vtxlab.model.Size;
import com.vtxlab.model.Cat;
import com.vtxlab.model.Color;


public class AnimalsTest {
  public static void main(String[] args) {
    
    Size size = new Size();
    Animals dog1 = new Dog(new Size(10, 20) , new Color("White"));
    Animals cat1 = new Cat(new Size(6, 13),new Color("Black"));
    dog1.eat();
    System.out.println(cat1.getAnimalsColor().getColor());

    Scanner input = new Scanner(System.in);
    System.out.print("Input Animals : ");
    int input1 = input.nextInt();
    

  }
}
