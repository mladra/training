package training.math.even;

public final class OnlyEvenNumberCheckerFactory {

    public static OnlyEvenNumberChecker loop() {
        return new OnlyEvenNumbersLoop();
    }

    public static OnlyEvenNumberChecker streams() {
        return new OnlyEvenNumbersStreams();
    }

}
