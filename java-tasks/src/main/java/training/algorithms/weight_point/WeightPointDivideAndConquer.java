package training.algorithms.weight_point;

import java.util.Arrays;

class WeightPointDivideAndConquer implements WeightPoint {

    @Override
    public int compute(int[] array) {
        return compute(array, 0, array.length);
    }

    private static int compute(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return 0;
        }

        if (low > high) {
            return -1;
        }

        int mid = (high - low) / 2 + low;
        int leftSum = Arrays.stream(array, 0, mid).sum();
        int rightSum = Arrays.stream(array, mid, array.length).sum();

        if (leftSum == rightSum) {
            return mid;
        } else if (leftSum > rightSum) {
            return compute(array, low, mid - 1);
        } else {
            return compute(array, mid + 1, high);
        }
    }
}
