package training.search;

import training.utils.TrainingUtils;

class BinarySearchIterative implements BinarySearch {

    @Override
    public int search(int[] array, int value) {
        if (!TrainingUtils.isSorted(array)) {
            System.err.println("Array is not sorted. Cannot perform binary search");
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int pivot = (right - left) / 2 + left;
            int pivotValue = array[pivot];

            if (pivotValue == value) {
                return pivot;
            } else if (pivotValue > value) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }
}
