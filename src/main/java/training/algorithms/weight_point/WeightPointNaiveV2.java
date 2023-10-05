package training.algorithms.weight_point;

import java.util.Arrays;

class WeightPointNaiveV2 implements WeightPoint {

    @Override
    public int compute(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return 0;
        }

        int sumLeft = 0;
        int sumRight = Arrays.stream(array).sum();
        for (int i = 0; i < array.length; i++) {
            sumLeft += array[i];
            sumRight -= array[i];
            if (sumLeft == sumRight) {
                return i + 1;
            }
        }

        return -1;
    }
}
