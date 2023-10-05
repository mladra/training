package training.sort;

import org.junit.jupiter.api.Disabled;

@Disabled("Algorithm needs to be implemented")
class QuickSortAlgorithmTest extends SortAlgorithmTest {

    protected QuickSortAlgorithmTest() {
        super(SortingAlgorithmFactory.quickSort());
    }
}
