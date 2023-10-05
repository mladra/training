package training.math.even;

import java.util.Collection;

class OnlyEvenNumbersStreams implements OnlyEvenNumberChecker {

    @Override
    public boolean containsOnlyEvenNumbers(Collection<Integer> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }

        return collection.stream().noneMatch(number -> number % 2 == 1);
    }
}
