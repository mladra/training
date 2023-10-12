package training.algorithms.fizz_buzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class FizzBuzzSolutionTest {

    private final FizzBuzzSolution fizzBuzzSolution;

    protected FizzBuzzSolutionTest(FizzBuzzSolution fizzBuzzSolution) {
        this.fizzBuzzSolution = fizzBuzzSolution;
    }

    @ParameterizedTest
    @MethodSource("fizzBuzz_source")
    void test(int number, String expectedResult) {
        String result = fizzBuzzSolution.fizzBuzz(number);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> fizzBuzz_source() {
        return Stream.of(
                Arguments.of(0, "FizzBuzz"),
                Arguments.of(1, "1"),
                Arguments.of(2, "2"),
                Arguments.of(3, "Fizz"),
                Arguments.of(4, "4"),
                Arguments.of(5, "Buzz"),
                Arguments.of(6, "Fizz"),
                Arguments.of(7, "7"),
                Arguments.of(8, "8"),
                Arguments.of(9, "Fizz"),
                Arguments.of(10, "Buzz"),
                Arguments.of(11, "11"),
                Arguments.of(12, "Fizz"),
                Arguments.of(13, "13"),
                Arguments.of(14, "14"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(60, "FizzBuzz")
        );
    }

}
