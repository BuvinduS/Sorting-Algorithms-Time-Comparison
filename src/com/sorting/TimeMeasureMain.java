import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; //Using the List interface for the sorting algorithms instead of directly using ArrayList provides more flexibility


public class TimeMeasureMain {
    private static List<Integer> createArray(Scanner scanner, Random random){
        System.out.print("Enter array length: ");
        int limit = scanner.nextInt();
        if(limit <= 0){
            System.err.println("Error: please enter a valid value");
            System.exit(1);
        }
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < limit; i++){
            arr.add(random.nextInt(1000));
        }
        return arr;
    }

    private static void output(List<SortingAlgorithms> algorithms, List<Integer> arr,Scanner scanner){
        System.out.println("Select 2 sorting algorithms: ");
        for(int i = 0; i < algorithms.size(); i++){
            System.out.println((i+1)+"--> "+algorithms.get(i).getClass().getSimpleName());
        }
        System.out.println("Enter number of first algorithm; ");
        int firstChoice = scanner.nextInt() - 1; //Zero based indexing
        System.out.println("Enter number of second algorithm; ");
        int secondChoice = scanner.nextInt() - 1;
        System.out.println();
        List<Integer> arrFor1 = new ArrayList<>(arr);
        List<Integer> arrFor2 = new ArrayList<>(arr);

        SortingAlgorithms algo1 = algorithms.get(firstChoice);;
        SortingAlgorithms algo2 = algorithms.get(secondChoice);
        System.out.println("Print unsorted array? (Enter 1 if yes, other if no)");
        if(scanner.nextInt() == 1){
            System.out.println("Unsorted Array: ");
            algo1.printArray(arrFor1);
        }
        scanner.nextLine();
        System.out.println();
        long firstChoiceTime = algo1.measureTime(arrFor1);
        long secondChoiceTime = algo2.measureTime(arrFor2);
        
        System.out.println("Time taken by "+ (algo1.getClass().getSimpleName()) +" is: "+ firstChoiceTime+ " nanoseconds");
        System.out.println("Time taken by "+ (algo2.getClass().getSimpleName()) +" is: "+ secondChoiceTime+ " nanoseconds");

        System.out.println();
        System.out.println("Print sorted array? (Enter 1 if yes, other if no)");
        if(scanner.nextInt() == 1){
            System.out.println("Sorted Array: ");
            algo1.printArray(arrFor1);
        }
        scanner.nextLine();
        if (firstChoiceTime < secondChoiceTime){
            System.out.println(algo1.getClass().getSimpleName() + " was faster than "+algo2.getClass().getSimpleName()+" for an input size of "+arrFor1.size());
        }else{
            System.out.println(algo2.getClass().getSimpleName() + " was faster than "+algo1.getClass().getSimpleName()+" for an input size of "+arrFor1.size());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> arrForSorting = createArray(scanner, random);

        List<SortingAlgorithms> algorithms = new ArrayList<>();
        algorithms.add(new QuickSort());
        algorithms.add(new MergeSort());
        algorithms.add(new SelectionSort());
        algorithms.add(new BubbleSort());
        algorithms.add(new InsertionSort());
        algorithms.add(new TimSort());

        output(algorithms, arrForSorting, scanner);

        scanner.close();
    }
}
