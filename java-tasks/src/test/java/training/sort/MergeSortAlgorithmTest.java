package training.sort;

import org.junit.jupiter.api.Disabled;

@Disabled("Algorithm needs to be implemented")
class MergeSortAlgorithmTest extends SortAlgorithmTest {

    protected MergeSortAlgorithmTest() {
        super(SortingAlgorithmFactory.mergeSort());
    }
}
