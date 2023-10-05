package training.math.prime;

import java.util.Arrays;

class PrimeErastotenes implements PrimeNumberChecker {

    private final int maxNumber;
    private final boolean[] isPrime;
    private boolean initialized;

    public PrimeErastotenes(int maxNumber) {
        this.maxNumber = maxNumber;
        this.isPrime = new boolean[maxNumber + 1];
    }

    @Override
    public boolean isPrime(int number) {
        if (Math.abs(number) > maxNumber) {
            throw new IllegalArgumentException("Absolute value of provided number cannot be greater than " + maxNumber);
        }

        if (!initialized) {
            initErastoteles();
        }

        return isPrime[Math.abs(number)];
    }

    private void initErastoteles() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 3; i < maxNumber + 1; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < maxNumber + 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        initialized = true;
    }
}
