package training.algorithms.palindrome.number;

class NumberPalindromeWithStrings implements NumberPalindromeChecker {

    @Override
    public boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        String num = String.valueOf(number);
        String reversedNumber = new StringBuilder(num).reverse().toString();
        return num.equals(reversedNumber);
    }
}
