package training.search;

import training.utils.TrainingUtils;

class BinarySearchRecursive implements BinarySearch {

    @Override
    public int search(int[] array, int value) {
        if (!TrainingUtils.isSorted(array)) {
            System.err.println("Array is not sorted. Cannot perform binary search");
            return -1;
        }

        if (array == null || array.length == 0) {
            return -1;
        }

        return binarySearch(array, value, 0, array.length - 1);
    }

    private static int binarySearch(int[] sortedArray, int value, int left, int right) {
        if (right < left) {
            return -1;
        }

        int pivot = (right - left) / 2 + left;
        int pivotValue = sortedArray[pivot];
        if (pivotValue == value) {
            return pivot;
        }
        if (pivotValue > value) {
            return binarySearch(sortedArray, value, left, pivot - 1);
        } else {
            return binarySearch(sortedArray, value, pivot + 1, right);
        }
    }
}
