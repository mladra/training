package training.math.prime;

class PrimeNaive implements PrimeNumberChecker {

    @Override
    public boolean isPrime(int number) {
        int absNumber = Math.abs(number);

        if (absNumber == 0 || absNumber == 1) {
            return false;
        }

        for (int i = 2; i <= absNumber / 2; i++) {
            if (absNumber % i == 0) {
                return false;
            }
        }

        return true;
    }
}
