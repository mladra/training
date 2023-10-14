package training.algorithms.duplicate_characters;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class DuplicateCharactersSolutionImpl implements DuplicateCharactersSolution {

    @Override
    public Map<Character, Integer> find(String value) {
        Map<Character, Integer> charactersCount = new HashMap<>(value.length());

        for (Character character : value.toCharArray()) {
            charactersCount.putIfAbsent(character, 0);
            charactersCount.computeIfPresent(character, (key, count) -> count + 1);
        }

        return charactersCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
