package training.math.prime;

public final class PrimeNumberCheckerFactory {

    public static PrimeNumberChecker naive() {
        return new PrimeNaive();
    }

    public static PrimeNumberChecker erastotenes(int maxNumber) {
        return new PrimeErastotenes(maxNumber);
    }

}
