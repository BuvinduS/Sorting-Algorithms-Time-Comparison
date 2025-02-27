//import java.util.ArrayList;
import java.util.List;

public class BubbleSort extends SortingAlgorithms {
    private static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private static void bubbleSort(List<Integer> arr){
        boolean isSwapping;
        do{
            isSwapping = false;
            for(int i = 0; i < arr.size()-1; i++){
                if(arr.get(i) > arr.get(i+1)){
                    swap(arr, i, i+1);
                    isSwapping = true;
                }
            }
        }while(isSwapping);
    }

    @Override
    public void sort(List<Integer> arr) {
        bubbleSort(arr);
    }

    
}
