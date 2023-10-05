package training.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import training.utils.TrainingUtils;

import java.util.stream.Stream;

abstract class SortAlgorithmTest {

    private final SortingAlgorithm sortingAlgorithm;

    protected SortAlgorithmTest(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @ParameterizedTest
    @MethodSource("given_array_when_sort_then_returnSortedArray_source")
    void given_array_when_sort_then_returnSortedArray(int[] array) {
        int[] sortedArray = sortingAlgorithm.sort(array);
        Assertions.assertTrue(TrainingUtils.isSorted(sortedArray));
    }

    private static Stream<Arguments> given_array_when_sort_then_returnSortedArray_source() {
        return Stream.of(
                Arguments.of((Object) new int[]{0, 1, 2, 3, 4, 5}),
                Arguments.of((Object) new int[]{12, 5, 123, 1, -10, 34})
        );
    }
}
