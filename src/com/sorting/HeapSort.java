package com.sorting;

import java.util.List;

public class HeapSort extends SortingAlgorithms {
    public static void maxHeapify(List<Integer> arr, int arrSize, int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largest = index;

        if(left < arrSize && arr.get(left) > arr.get(largest)){
            largest = left;
        }
        if(right < arrSize && arr.get(right) > arr.get(largest)){
            largest = right;
        }

        if (largest != index){
            int temp = arr.get(largest);
            arr.set(largest, arr.get(index));
            arr.set(index, temp);
            maxHeapify(arr, arrSize, largest);
        }
    }

    public static void heapSort(List<Integer> arr){
        int start = (arr.size()/2) - 1;

        for (int i = start; i >= 0 ; i--) {
            maxHeapify(arr, arr.size(),i);
        }
        for (int j = arr.size() - 1; j > 0 ; j--) {
            int temp = arr.get(j);
            arr.set(j, arr.get(0));
            arr.set(0, temp);
            maxHeapify(arr, j, 0);
        }
    }

    @Override
    public void sort(List<Integer> arr) {
        heapSort(arr);
    }
}
