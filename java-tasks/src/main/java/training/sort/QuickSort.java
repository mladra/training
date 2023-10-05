package training.sort;

import java.util.Arrays;

class QuickSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        return quickSort(array);
    }

    private static int[] quickSort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        quickSort(copy, 0, copy.length);
        return copy;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) return;

        int pivot = (high - low) / 2 + low;
        int pivotValue = array[pivot];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivotValue) {
                i++;
            }

            while (array[j] >= pivotValue) {
                j--;
            }

            int value = array[i];
            array[i] = array[j];
            array[j] = value;
        }

        quickSort(array, low, pivot);
        quickSort(array, pivot, high);
    }
}
