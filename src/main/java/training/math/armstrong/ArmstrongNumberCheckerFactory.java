package training.math.armstrong;

public final class ArmstrongNumberCheckerFactory {

    public static ArmstrongNumberChecker stringImplementation() {
        return new ArmstrongNumberWithStrings();
    }

    public static ArmstrongNumberChecker numberImplementation() {
        return new ArmstrongNumber();
    }

}
