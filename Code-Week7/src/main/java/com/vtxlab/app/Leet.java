package com.vtxlab.app;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet {
  public String removeDuplicates(String S) {
    Deque<Character> dq = new ArrayDeque<>();
    for (char c : S.toCharArray()) {
        if (!dq.isEmpty() && dq.peekLast() == c) { 
            dq.pollLast();
        }else {
            dq.offer(c);
        }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : dq) { sb.append(c); }
    return sb.toString();
}
  public static void main(String[] args) {
    
    String r = "xzzzy";
    Leet v =new Leet();
   System.out.println(v.removeDuplicates(r));
    
    
  }
}
