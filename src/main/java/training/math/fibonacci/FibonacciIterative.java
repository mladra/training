package training.math.fibonacci;

class FibonacciIterative implements Fibonacci {

    @Override
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N cannot be negative");
        }

        int first = 1;
        int second = 1;

        if (n == 0) return first;
        if (n == 1) return second;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
