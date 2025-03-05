import java.util.List;

public class TimSort extends SortingAlgorithms {
    final static int RUN = 32;

    private void timSort(List<Integer> arr, int size){
        for(int i = 0; i < size; i += RUN){
            int end = Math.min((i + RUN - 1), size-1);
            InsertionSort.insertionSortWrapper(arr,i, end);
        }
        // Start merging from size RUN
        // It will then double in size countinuously
        for(int n = RUN; n < size; n *= 2){
            // Pick starting points of sub arrays
            for(int left = 0; left < size; left += 2*size){
                // Pick ending points of sub arrays
                int mid = left + size - 1;
                int right = Math.min((left + (2*size)-1), size - 1);

                if(mid < right){
                    MergeSort.mergeSortWrapper(arr, left, right);
                }
            }
        }
    }

    @Override
    public void sort(List<Integer> arr) {
        timSort(arr, arr.size());
    }
}
