package training.spoj.PP0504B;

import java.util.Scanner;

// https://pl.spoj.com/problems/PP0504B/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casesCount = scanner.nextInt();

        for (int i = 0; i < casesCount; i++) {
            String first = scanner.next();
            String second = scanner.next();
            int length = Math.min(first.length(), second.length());
            char[] firstCharacters = first.toCharArray();
            char[] secondCharacters = second.toCharArray();

            StringBuilder out = new StringBuilder();
            for (int j = 0; j < length; j++) {
                out.append(firstCharacters[j]);
                out.append(secondCharacters[j]);
            }
            System.out.println(out);
        }
    }

}
