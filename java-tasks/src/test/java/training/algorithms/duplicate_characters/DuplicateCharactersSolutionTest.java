package training.algorithms.duplicate_characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

abstract class DuplicateCharactersSolutionTest {

    private final DuplicateCharactersSolution solution;

    protected DuplicateCharactersSolutionTest(DuplicateCharactersSolution solution) {
        this.solution = solution;
    }

    @ParameterizedTest
    @MethodSource("checkForDuplicates_source")
    void checkForDuplicates(String word, Map<Character, Integer> expectedResult) {
        Map<Character, Integer> result = solution.find(word);
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> checkForDuplicates_source() {
        return Stream.of(
                Arguments.of("Better Butter", Map.of('t', 4, 'e', 3, 'r', 2, 'B', 2)),
                Arguments.of("     ", Map.of(' ', 5)),
                Arguments.of("y", Collections.emptyMap()),
                Arguments.of("aha", Map.of('a', 2)),
                Arguments.of("-112340-", Map.of('-', 2, '1', 2))
        );
    }
}
