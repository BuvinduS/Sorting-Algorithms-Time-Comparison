import java.util.ArrayList;
import java.util.List;
public class MergeSort extends SortingAlgorithms {
    private static void merge(List<Integer> arr, int left,int mid, int right){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        List<Integer> arrL = new ArrayList<>(leftSize + 1);
        List<Integer> arrR = new ArrayList<>(rightSize + 1);

        for(int i = 0; i < leftSize; i++){
            arrL.add(arr.get(left + i));
        }
        for(int j = 0; j < rightSize; j++){
            arrR.add(arr.get(mid + 1 + j));
        }

        arrL.add(Integer.MAX_VALUE);
        arrR.add(Integer.MAX_VALUE);

        int i = 0; int j = 0; int k = left;
        while(i < leftSize || j < rightSize){
            if(arrL.get(i) < arrR.get(j)){
                arr.set(k, arrL.get(i));
                i++;
            }else{
                arr.set(k, arrR.get(j));
                j++;
            }
            k++;
        }
    }
    private static void mergeSort(List<Integer> arr, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    @Override
    public void sort(List<Integer> arr) {
        mergeSort(arr, 0, arr.size()-1);
    }
}
