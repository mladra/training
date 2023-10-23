package math.fibonacci

trait FibonacciIterative {

    def iterative(int n) {
        if (n < 0) throw new IllegalArgumentException("N cannot be negative")

        def first = 0
        def second = 1

        if (n == 0) return first
        if (n == 1) return second

        for (int i = 2; i <= n; i++) {
            def third = first + second
            first = second
            second = third
        }

        return second
    }

}