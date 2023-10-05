package training.algorithms.palindrome.string;

public final class PalindromeCheckerFactory {

    public static PalindromeChecker charArrayImplementation() {
        return new Palindrome();
    }

    public static PalindromeChecker stringBuilderImplementation() {
        return new PalindromeWithStringBuilder();
    }

}
