package training.algorithms.fizz_buzz;

public final class FizzBuzzFactory {

    public static FizzBuzzSolution fizzBuzzImpl() {
        return new FizzBuzzImpl();
    }

    public static FizzBuzzSolution fizzBuzzImpl2() {
        return new FizzBuzzImpl2();
    }

    public static FizzBuzzSolution fizzBuzzStringImpl() {
        return new FizzBuzzStringImpl();
    }

}
