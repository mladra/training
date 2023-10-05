package training.math.even;

import java.util.Collection;

class OnlyEvenNumbersLoop implements OnlyEvenNumberChecker {

    @Override
    public boolean containsOnlyEvenNumbers(Collection<Integer> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }

        for (Integer number : collection) {
            if (number % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}
