package com.vtxlab.app;

import com.vtxlab.interfaces.Lambda;
import com.vtxlab.interfaces.SortHelper;

public class Sort {

  public static void sort(int[] arr, SortHelper sortHelper) {
    sortHelper.sort(arr);
  }

  public static void swap(int[] arr, int i, int j) {

    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void seletionSort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {
      int min = arr[i];
      int index = 0;
      for (int j = i + 1; j < arr.length; j++) {

        if (arr[j] < min) {
          min = arr[j];
          index = j;
        }
        if (index != 0) {
          swap(arr, index, i);
        }

      }
    }
  }

    public static final void print(int[] arr){
      for ( int c : arr){
      System.out.print(c);
      }
  }



  public static void main(String[] args) {

    // int [] arr1 = new int[]{11,5,7,19,4,1,7};

    /*
     * 
     * for (int i = 0 ; i < arr1.length-1 ; i++){
     * int j = arr1[i+1];
     * if(arr1[j] > arr1[i]){
     * Sort.swap(arr1, i, j);
     * }
     * }
     */

    int[] arr2 = new int[] { 14, 26, 10, 5, 3 };

    SortHelper selectionSort = (int[] arr) -> {
      Sort.seletionSort(arr2);
      print(arr2);
    };

    int[] arr3 = { 4, 3, 7, 8, 2 };
    Lambda.sort(arr3, selectionSort);
  
}
}
