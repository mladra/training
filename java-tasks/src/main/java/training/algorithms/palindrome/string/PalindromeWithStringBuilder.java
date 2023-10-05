package training.algorithms.palindrome.string;

class PalindromeWithStringBuilder implements PalindromeChecker {

    @Override
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }

        String reversed = new StringBuilder(word).reverse().toString();
        return reversed.equalsIgnoreCase(word);
    }
}
