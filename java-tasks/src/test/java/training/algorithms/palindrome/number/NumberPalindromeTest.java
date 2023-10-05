package training.algorithms.palindrome.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class NumberPalindromeTest {

    private final NumberPalindromeChecker numberPalindromeChecker;

    protected NumberPalindromeTest(NumberPalindromeChecker numberPalindromeChecker) {
        this.numberPalindromeChecker = numberPalindromeChecker;
    }

    @ParameterizedTest
    @MethodSource("given_number_when_checkIfItsPalindrome_then_returnCorrectResult_source")
    void given_number_when_checkIfItsPalindrome_then_returnCorrectResult(int number, boolean expectedResult) {
        boolean result = numberPalindromeChecker.isPalindrome(number);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> given_number_when_checkIfItsPalindrome_then_returnCorrectResult_source() {
        return Stream.of(
                Arguments.of(1001, true),
                Arguments.of(1234, false),
                Arguments.of(1, true),
                Arguments.of(1000001, true),
                Arguments.of(1234321, true),
                Arguments.of(-100, false)
        );
    }
}
