package training.algorithms.weight_point;

import java.util.Arrays;

class WeightPointNaive implements WeightPoint {

    @Override
    public int compute(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return 0;
        }

        for (int i = 1; i < array.length; i++) {
            int sumLeft = Arrays.stream(array, 0, i).sum();
            int sumRight = Arrays.stream(array, i, array.length).sum();
            if (sumLeft == sumRight) {
                return i;
            }
        }

        return -1;
    }
}
