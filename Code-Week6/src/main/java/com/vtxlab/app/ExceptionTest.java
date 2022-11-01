package com.vtxlab.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vtxlab.app.enums.Exceptions;
import com.vtxlab.app.exceptions.MobileBackendException;

public class ExceptionTest {
  
  //throws
  public int getSomeInteger(String filePath) throws FileNotFoundException{
    Scanner scanner = new Scanner(new File(filePath));
    return Integer.parseInt(scanner.nextLine());
  }

  //try-catch
  public int getSomeInteger2(String filePath){
    try{
      Scanner scanner = new Scanner(new File(filePath));
      return Integer.parseInt(scanner.nextLine());
    }catch(FileNotFoundException e){
      System.out.println("file not found! Returning 0...");
      return 0;
    }
  }

  public static void main(String[] args) {
    

    List<Integer> ls1 = new ArrayList<>();
    ls1.add(3);
    ls1.add(2);
    ls1.add(1);
    
    String str = null;
  try{
    System.out.println(str.length());
  } catch (NullPointerException e){
    System.out.println("this string is null");
  }

  try{
  String s="abc";  
  int i=Integer.parseInt(s);//NumberFormatException 
  } catch(NumberFormatException e){
    System.out.println(e.getMessage());
  }


  try{
      String a = null;
      char b = a.charAt(0);
  } catch(NullPointerException e){
    System.out.println("NullPointerException...");
  }

  ExceptionTest.print(17);

}

  public static void print(int a){
  if( a >= 18){
    System.out.println("Eligible for Voting");
  } else {
    throw new IllegalArgumentException("Not Eligible for Voting...");
  }


 }
}

