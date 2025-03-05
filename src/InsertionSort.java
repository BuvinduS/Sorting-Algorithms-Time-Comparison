import java.util.List;
public class InsertionSort extends SortingAlgorithms{
    public static void insertionSort(List<Integer> arr, int left, int right){
        int size = right - left + 1;
        for(int ptr = 1; ptr < size-1; ptr++){
            int i = ptr - 1;
            int temp = arr.get(ptr);
            while(i >= 0 && temp < arr.get(i)){
                arr.set(i+1, arr.get(i));
                i--;
            }
            arr.set(i+1, temp);
        }
    }
    public static void insertionSortWrapper(List<Integer> arr, int left, int right){
        insertionSort(arr, left, right);
    }


    @Override
    public void sort(List<Integer> arr) {
        insertionSort(arr, 0, arr.size());
    }
}
