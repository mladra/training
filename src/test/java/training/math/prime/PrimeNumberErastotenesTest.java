package training.math.prime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeNumberErastotenesTest extends PrimeNumberCheckerTest {

    private static final int MAX_NUMBER = 100;

    protected PrimeNumberErastotenesTest() {
        super(PrimeNumberCheckerFactory.erastotenes(MAX_NUMBER));
    }

    @Test
    void given_numberGreaterThanMaxNumber_when_checkIfPrime_then_throwException() {
        // given
        int number = 112;

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> primeNumberChecker.isPrime(number));
    }

    @Test
    void given_absoluteNumberGreaterThanMaxNumber_when_checkIfPrime_then_throwException() {
        // given
        int number = -112;

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> primeNumberChecker.isPrime(number));
    }
}
