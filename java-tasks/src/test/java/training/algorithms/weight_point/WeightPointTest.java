package training.algorithms.weight_point;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class WeightPointTest {

    private final WeightPoint weightPoint;

    protected WeightPointTest(WeightPoint weightPoint) {
        this.weightPoint = weightPoint;
    }

    @ParameterizedTest
    @MethodSource("given_array_when_computeWeightPoint_then_returnCorrectIndex_source")
    void given_array_when_computeWeightPoint_then_returnCorrectIndex(int[] array, int expectedIndex) {
        int resultIndex = weightPoint.compute(array);
        Assertions.assertEquals(expectedIndex, resultIndex);
    }

    private static Stream<Arguments> given_array_when_computeWeightPoint_then_returnCorrectIndex_source() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 3, 2, 1}, 3),
                Arguments.of(new int[]{1, 2, 100, 3, 2, 1}, -1),
                Arguments.of(new int[]{1, 6, 1, 2, 4}, 2),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{20}, 0),
                Arguments.of(new int[0], -1)
        );
    }
}
