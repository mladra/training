package training.algorithms.palindrome.string;

class Palindrome implements PalindromeChecker {

    @Override
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }

        char[] charArray = word.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

}
