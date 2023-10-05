package training.math.even;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

abstract class OnlyEvenNumbersCheckerTest {

    private final OnlyEvenNumberChecker onlyEvenNumberChecker;

    protected OnlyEvenNumbersCheckerTest(OnlyEvenNumberChecker onlyEvenNumberChecker) {
        this.onlyEvenNumberChecker = onlyEvenNumberChecker;
    }

    @ParameterizedTest
    @MethodSource("given_numberCollection_when_checkIfContainsOnlyEventNumbers_then_returnCorrectResult_source")
    void given_numberCollection_when_checkIfContainsOnlyEventNumbers_then_returnCorrectResult(Collection<Integer> numbers, boolean expectedResult) {
        boolean result = onlyEvenNumberChecker.containsOnlyEvenNumbers(numbers);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> given_numberCollection_when_checkIfContainsOnlyEventNumbers_then_returnCorrectResult_source() {
        return Stream.of(
                Arguments.of(List.of(2, 4, 5, 7, 8, 10), false),
                Arguments.of(List.of(2, 4, 6, 8, 10), true),
                Arguments.of(List.of(), false),
                Arguments.of(null, false)
        );
    }
}
