package training.spoj.PA05_POT;

import java.util.Scanner;

// https://pl.spoj.com/problems/PA05_POT/
// TODO: mladra: Not solved !!!
public class Main {

    private static final int[][] POSSIBLE_NUMBERS = new int[][]{
            new int[]{0},
            new int[]{1},
            new int[]{2, 4, 8, 6},
            new int[]{3, 9, 7, 1},
            new int[]{4, 6},
            new int[]{5},
            new int[]{6},
            new int[]{7, 9, 3, 1},
            new int[]{8, 4, 2, 6},
            new int[]{9, 1},
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int casesCount = scanner.nextInt();
            for (int i = 0; i < casesCount; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                if (b == 0) {
                    System.out.println(1);
                    return;
                }

                int digit = a % 10;
                int[] possibleNumbersForDigit = POSSIBLE_NUMBERS[digit];
                int lastDigit = possibleNumbersForDigit[(b % possibleNumbersForDigit.length) - 1];
                System.out.println(lastDigit);
            }
        } catch (Exception exception) {
            return;
        }
    }

}
