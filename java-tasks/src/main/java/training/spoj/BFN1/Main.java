package training.spoj.BFN1;

import java.util.Scanner;

// https://pl.spoj.com/problems/BFN1/
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int casesCount = scanner.nextInt();
            for (int i = 0; i < casesCount; i++) {
                int additionsCount = 0;
                String numAsString = scanner.next();
                if (numAsString.length() == 1) {
                    System.out.println(numAsString + " " + 0);
                    continue;
                }

                int prev = Integer.parseInt(numAsString);
                int current;
                while (true) {
                    String reversed = new StringBuilder(String.valueOf(prev)).reverse().toString();
                    current = Integer.parseInt(reversed);
                    if (prev == current) {
                        break;
                    }

                    prev = prev + current;
                    additionsCount++;
                }

                System.out.println(prev + " " + additionsCount);
            }
        } catch (Exception exception) {
            return;
        }
    }

}
