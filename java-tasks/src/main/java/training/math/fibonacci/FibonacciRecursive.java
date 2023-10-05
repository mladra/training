package training.math.fibonacci;

class FibonacciRecursive implements Fibonacci {

    @Override
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N cannot be negative");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci( n - 2);
    }
}
