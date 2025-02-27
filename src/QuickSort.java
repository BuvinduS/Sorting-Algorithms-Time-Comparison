//import java.util.ArrayList;
import java.util.List;

public class QuickSort extends SortingAlgorithms {
    private static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    private static int partition(List<Integer> arr, int low, int high){
        int pivot = arr.get(high);
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(arr.get(j) < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }
    private static void quickSort(List<Integer> arr, int low, int high){
        if (low < high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }   
    }
    @Override
    public void sort(List<Integer> arr) {
        quickSort(arr, 0, arr.size()-1);
    }
}
