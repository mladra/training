package training.math.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class FibonacciTest {

    private final Fibonacci fibonacci;

    protected FibonacciTest(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    @Test
    void given_fibonacciRecursive_when_negativeNumber_then_exceptionIsThrown() {
        int n = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> fibonacci.fibonacci(n));
    }

    @ParameterizedTest
    @MethodSource("given_n_when_fibonacci_then_returnCorrectNumber_source")
    void given_n_when_fibonacci_then_returnCorrectNumber(int n, int expected) {
        long result = fibonacci.fibonacci(n);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> given_n_when_fibonacci_then_returnCorrectNumber_source() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(6, 13),
                Arguments.of(7, 21),
                Arguments.of(8, 34),
                Arguments.of(9, 55),
                Arguments.of(10, 89),
                Arguments.of(11, 144),
                Arguments.of(12, 233),
                Arguments.of(13, 377),
                Arguments.of(14, 610),
                Arguments.of(15, 987),
                Arguments.of(16, 1597)
        );
    }

}
