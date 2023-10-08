package training.algorithms.weight_point;

import java.util.Arrays;

public class WeightPointNaiveFromBothSides implements WeightPoint {

    @Override
    public int compute(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return 0;
        }

        int leftIdx = 0;
        int rightIdx = array.length;

        while (leftIdx <= rightIdx) {
            int leftSum = Arrays.stream(array, 0, leftIdx).sum();
            int rightSum = Arrays.stream(array, leftIdx, array.length).sum();
            if (leftSum == rightSum) {
                return leftIdx;
            }

            leftSum = Arrays.stream(array, 0, rightIdx).sum();
            rightSum = Arrays.stream(array, rightIdx, array.length).sum();
            if (leftSum == rightSum) {
                return rightIdx;
            }

            leftIdx++;
            rightIdx--;
        }

        return -1;
    }
}
