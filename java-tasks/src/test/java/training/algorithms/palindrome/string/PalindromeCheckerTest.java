package training.algorithms.palindrome.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class PalindromeCheckerTest {

    private final PalindromeChecker palindromeChecker;

    protected PalindromeCheckerTest(PalindromeChecker palindromeChecker) {
        this.palindromeChecker = palindromeChecker;
    }

    @ParameterizedTest
    @MethodSource("given_word_when_checkPalindrome_then_returnCorrectResult_source")
    void given_word_when_checkPalindrome_then_returnCorrectResult(String word, boolean expectedResult) {
        boolean result = palindromeChecker.isPalindrome(word);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> given_word_when_checkPalindrome_then_returnCorrectResult_source() {
        return Stream.of(
                Arguments.of("Bob", true),
                Arguments.of("bbbb", true),
                Arguments.of("Hardrah", true),
                Arguments.of("Michael", false),
                Arguments.of("A", true),
                Arguments.of("", true),
                Arguments.of(null, false)
        );
    }
}
