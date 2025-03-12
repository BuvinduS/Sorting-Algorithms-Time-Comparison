package com.sorting;
//import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlgorithms {
    /*This is an abstract class that will have the basic structure every sorting algorithm will follow
    It includes methods for:
          sorting the array: sort(int[] arr);
          measuring time: measureTime(int[] arr);
    */
    
    public abstract void sort(List<Integer> arr);
    
    public long measureTime(List<Integer> arr){
        long start = System.nanoTime();
        sort(arr); //Run the specific algorithm
        long stop = System.nanoTime();
        return stop - start;
    }

    public void printArray(List<Integer> arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
