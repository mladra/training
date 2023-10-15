package training.spoj.FLAMASTE;

import java.util.Scanner;

// https://pl.spoj.com/problems/FLAMASTE/
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int casesCount = scanner.nextInt();
            for (int i = 0; i < casesCount; i++) {
                String word = scanner.next();
                char[] charArray = word.toCharArray();
                int j = 0;
                StringBuilder result = new StringBuilder();
                while (j < charArray.length) {
                    int counts = 1;
                    for (int k = j + 1; k < charArray.length; k++) {
                        if (charArray[k] == charArray[j]) {
                            counts++;
                        } else {
                            break;
                        }
                    }

                    if (counts > 2) {
                        result.append(charArray[j]).append(counts);
                    } else {
                        result.append(String.valueOf(charArray[j]).repeat(Math.max(0, counts)));
                    }

                    j += counts;
                }
                System.out.println(result);
            }
        } catch (Exception exception) {
            return;
        }
    }

}
