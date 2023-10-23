package math.fibonacci

trait FibonacciRecursive {

    def recursive(int n) {
        if (n < 0) throw new IllegalArgumentException("N cannot be negative")
        if (n == 0) return 0
        if (n == 1) return 1
        return recursive(n - 1) + recursive(n - 2)
    }

}