package vtxlab.app.course3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exersice7 {



  public static void main(String[] args) {
    String s = "leetcode";
  

    getIndex(s);
    Map<Integer,Integer> map = new HashMap<>();
    int[] intArray = {5,9,6,10,3,8,1};
    for(int i : intArray){
      map.put(i, i);
    }

    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
      if(entry.getKey() == 3){
        map.remove(entry.getKey());
      }
      System.out.println("key : " + entry.getKey() + "  Value : " + entry.getValue());
    }


  


    Map<Integer,Integer> map1 = new HashMap<>();
    map1.put(5, 5);
    map1.put(9, 9);
    map1.put(6, 6);
    map1.put(10, 10);
    map1.put(3, 3);
    map1.put(8, 8);
    map1.put(1, 1);

    map1.forEach((k,v) -> {
     // System.out.println(k,v);
    });

  
    
   // map1.forEach(map1.entrySet());

    Map<Integer,Integer> map2 = new LinkedHashMap<>();





  }


  public static int getIndex(String s){
    int count = 0;
    if(s == null || "".equals(s)){
      return -1;
    }
    Map<Integer,Character> map = new HashMap<>();

    for(Integer i =0 ; i <s.length() ; i++){
      map.put(i, s.charAt(i));
    }
    
    for(int i = 0; i<s.length();i++){
      
      
    }
    System.out.println(count);
  return count;

  }
}
