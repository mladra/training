package training.math.armstrong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class ArmstrongNumberTest {

    private final ArmstrongNumberChecker armstrongNumberChecker;

    protected ArmstrongNumberTest(ArmstrongNumberChecker armstrongNumberChecker) {
        this.armstrongNumberChecker = armstrongNumberChecker;
    }

    @ParameterizedTest
    @MethodSource("given_number_when_checkIfItsArmstrong_then_returnCorrectResult_source")
    void given_number_when_checkIfItsArmstrong_then_returnCorrectResult(int number, boolean expectedResult) {
        boolean result = armstrongNumberChecker.isArmstrongNumber(number);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> given_number_when_checkIfItsArmstrong_then_returnCorrectResult_source() {
        return Stream.of(
                Arguments.of(153, true),
                Arguments.of(256, false),
                Arguments.of(370, true),
                Arguments.of(370, true),
                Arguments.of(407, true),
                Arguments.of(444, false),
                Arguments.of(1634, true),
                Arguments.of(8208, true)
        );
    }
}
