package training.sort;

import java.util.Arrays;

class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        return bubbleSort(array);
    }

    private static int[] bubbleSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < result.length - 1; j++) {
                for (int k = i + 1; k < result.length; k++) {
                    if (result[j] > result[k]) {
                        swap(result, j, k);
                    }
                }
            }
        }

        return result;
    }

    private static void swap(int[] result, int j, int k) {
        int value = result[j];
        result[j] = result[k];
        result[k] = value;
    }
}
