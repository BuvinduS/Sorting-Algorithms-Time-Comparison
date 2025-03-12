package com.sorting;
//import java.util.ArrayList;
import java.util.List;

public class SelectionSort extends SortingAlgorithms {
    private static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private static void selectionSort(List<Integer> arr){
        for(int i = 0; i < arr.size()-1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.size(); j++){
                if(arr.get(j) < arr.get(minIndex)){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    @Override
    public void sort(List<Integer> arr) {
        selectionSort(arr);
    }
    
}
