package training.math.fibonacci;

public final class FibonacciFactory {

    public static Fibonacci createFibonacciRecursive(boolean withCache) {
        if (withCache) {
            return new FibonacciRecursiveWithCache();
        }

        return new FibonacciRecursive();
    }

    public static Fibonacci createFibonacciIterative() {
        return new FibonacciIterative();
    }

}
