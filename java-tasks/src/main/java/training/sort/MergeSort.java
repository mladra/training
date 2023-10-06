package training.sort;

import java.util.Arrays;

class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        mergeSort(copy, array.length);
        return copy;
    }

    private void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(array, 0, l, 0, mid);
        if (n - mid >= 0) {
            System.arraycopy(array, mid, r, 0, n - mid);
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(array, l, r, mid, n - mid);
    }

    private void merge(int[] array, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }
}
