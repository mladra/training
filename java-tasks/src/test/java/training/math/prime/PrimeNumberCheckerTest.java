package training.math.prime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class PrimeNumberCheckerTest {

    protected final PrimeNumberChecker primeNumberChecker;

    protected PrimeNumberCheckerTest(PrimeNumberChecker primeNumberChecker) {
        this.primeNumberChecker = primeNumberChecker;
    }

    @ParameterizedTest
    @MethodSource("given_number_when_checkIfItsPrime_then_returnCorrectResult_source")
    void given_number_when_checkIfItsPrime_then_returnCorrectResult(int number, boolean expectedResult) {
        boolean result = primeNumberChecker.isPrime(number);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> given_number_when_checkIfItsPrime_then_returnCorrectResult_source() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(5, true),
                Arguments.of(10, false),
                Arguments.of(14, false),
                Arguments.of(17, true),
                Arguments.of(29, true),
                Arguments.of(69, false),
                Arguments.of(71, true),
                Arguments.of(100, false),
                Arguments.of(-5, true),
                Arguments.of(-10, false),
                Arguments.of(-14, false),
                Arguments.of(-17, true),
                Arguments.of(-100, false)
        );
    }
}
