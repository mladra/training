package training.math.fibonacci;

import java.util.ArrayList;
import java.util.List;

class FibonacciRecursiveWithCache implements Fibonacci {

    private static final List<Long> FIBONACCI_CACHE = new ArrayList<>(List.of(1L, 1L));

    @Override
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N cannot be negative");
        }

        if (FIBONACCI_CACHE.size() - 1 < n) {
            long fib = fibonacci(n - 1) + fibonacci(n - 2);
            FIBONACCI_CACHE.add(fib);
        }

        return FIBONACCI_CACHE.get(n);
    }
}
