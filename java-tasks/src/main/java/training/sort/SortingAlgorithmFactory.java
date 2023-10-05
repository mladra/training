package training.sort;

public final class SortingAlgorithmFactory {

    public static SortingAlgorithm bubbleSort() {
        return new BubbleSort();
    }

    public static SortingAlgorithm quickSort() {
        return new QuickSort();
    }

    public static SortingAlgorithm mergeSort() {
        return new MergeSort();
    }

}
