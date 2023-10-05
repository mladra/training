package training.algorithms.palindrome.number;

import java.util.ArrayList;
import java.util.List;

class NumberPalindromeWithNumbers implements NumberPalindromeChecker {

    @Override
    public boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        int palindrome = calculatePalindrome(number);
        return palindrome == number;
    }

    private static int calculatePalindrome(int number) {
        List<Integer> digits = getDigitsCollection(number);
        int palindrome = 0;
        for (int i = 0; i < digits.size(); i++) {
            Integer digit = digits.get(i);
            palindrome += digit;
            if (i != digits.size() - 1) {
                palindrome *= 10;
            }
        }
        return palindrome;
    }

    private static List<Integer> getDigitsCollection(int number) {
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            int digit = number % 10;
            digits.add(digit);
            number -= digit;
            number /= 10;
        }

        return digits;
    }
}
