package vtxlab.app.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
   For each index i, names[i] and heights[i] denote the name and height of the ith person. Return the highest person
   Example 1:
   Input: names = ["Mary","John","Emma"], heights = [180,165,170] 
   Output: ["Mary","Emma","John"]
   Explanation: Mary is the tallest

   Example 2:
   Input: names = ["Alice","Bob","Bob"], heights = [155,185,150] 
   Output: ["Bob","Alice","Bob"]
   Explanation: The first Bob is the tallest

 */
public class Exercise1 {
  public static String[] tall(String[] names, int[] heights){
    Map<Integer,String> map1 = new HashMap<>();
    for(int i = 0; i < heights.length ; i++){
    map1.put(heights[i], names[i]);
    System.out.println(map1);
    }
    Arrays.sort(heights);
    String[] result = new String[heights.length];
    int index =0;
    for( int i = heights.length -1  ; i >= 0 ; i-- ){
      result[index] = map1.get(heights[i]);
      index++;
      System.out.println(Arrays.toString(result));
    }
    return result;
  }

  public static String[] sortpeople(String[] names , int[] heights){
   int[] arr = new int[167];
   for(int i =0; i < heights.length ; i++){
    arr[heights[i]] = i;
    System.err.println(Arrays.toString(arr));
   }
   Arrays.sort(heights);
    String[] result = new String[names.length];
    for(int i =0; i<heights.length;i++){
      result[heights.length -i-1] = names[arr[heights[i]]];
    }
    return result;
  }

  public static void main(String[] args) {
    String[] names = {"Mary","John","Emma"};
    int[] heights = {180,165,170};
   System.out.println(Arrays.toString(tall(names, heights)));
   //Input: names = ["Alice","Bob","Bob"], heights = [155,185,150] Output: ["Bob","Alice","Bob"]
   String[] names2 = {"Alice","Bob","Bob"};
   int[] heights2 = {155,185,150};
   System.out.println(Arrays.toString(tall(names2, heights2)));

   System.out.println(Arrays.toString(sortpeople(names, heights)));
   System.out.println(Arrays.toString(sortpeople(names2, heights2)));
  }
}
