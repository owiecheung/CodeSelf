package com.vtxlab.Week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Week4Day4 {
  public static void main(String[] args) {
    
    LinkedList<String> abc = new LinkedList<>();
    
    abc.addFirst("2334");
    //System.out.println(abc.size());

    List<String> bcd = new ArrayList<>();

    bcd.add("1");
    bcd.add("b");
    bcd.add("g");
    //System.out.println(bcd.size());




    int[] nums = new int[] {2,7,11,15};
    int target = 9;

    for (int i =0 ; i <nums.length -1 ; i++ ){
      for(int j = i+1 ; j < nums.length ; j++ ){
          
          if(nums[i] + nums[j] == target){
            System.out.println(i + " ," +j);
          }
      }
  }


  }
}
