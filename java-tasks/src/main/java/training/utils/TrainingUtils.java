package training.utils;

public final class TrainingUtils {

    public static boolean isSorted(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static int pow(int number, int pow) {
        int sum = 1;
        for (int i = 0; i < pow; i++) {
            sum *= number;
        }
        return sum;
    }
}
