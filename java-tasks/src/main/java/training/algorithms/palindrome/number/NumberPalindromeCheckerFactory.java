package training.algorithms.palindrome.number;

public final class NumberPalindromeCheckerFactory {

    public static NumberPalindromeChecker stringImplementation() {
        return new NumberPalindromeWithStrings();
    }

    public static NumberPalindromeChecker numbersImplementation() {
        return new NumberPalindromeWithNumbers();
    }

}
