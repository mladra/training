package training.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class BinarySearchTest {

    private final BinarySearch binarySearch;

    protected BinarySearchTest(BinarySearch binarySearch) {
        this.binarySearch = binarySearch;
    }

    @ParameterizedTest
    @MethodSource("given_sortedArray_when_findNumber_then_returnCorrectIndex_source")
    void given_sortedArray_when_findNumber_then_returnCorrectIndex(int[] sortedArray, int searchedValue, int expectedIndex) {
        int index = binarySearch.search(sortedArray, searchedValue);
        Assertions.assertEquals(expectedIndex, index);
    }

    private static Stream<Arguments> given_sortedArray_when_findNumber_then_returnCorrectIndex_source() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, -1, 0),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 0, 1),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 2, 2),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 3, 3),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 5, 4),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 17, 5),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 22, 6),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 55, -1),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, -55, -1),
                Arguments.of(new int[]{-1, 0, 2, 3, 5, 17, 22}, 12, -1),
                Arguments.of(new int[]{7, 1, 12, 5}, 12, -1),
                Arguments.of(new int[0], 10, -1)
        );
    }
}
