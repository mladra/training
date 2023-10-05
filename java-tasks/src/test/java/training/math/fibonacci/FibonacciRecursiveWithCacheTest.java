package training.math.fibonacci;

class FibonacciRecursiveWithCacheTest extends FibonacciTest {

    FibonacciRecursiveWithCacheTest() {
        super(FibonacciFactory.createFibonacciRecursive(true));
    }
}
