package training.spoj.PP0502B;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

// https://pl.spoj.com/problems/PP0502B/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casesCount = scanner.nextInt();

        for (int i = 0; i < casesCount; i++) {
            int numbersCount = scanner.nextInt();
            int[] numbers = new int[numbersCount];

            for (int j = 0; j < numbersCount; j++) {
                int number = scanner.nextInt();
                numbers[numbersCount - j - 1] = number;
            }

            String out = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(out);
        }
    }

}
