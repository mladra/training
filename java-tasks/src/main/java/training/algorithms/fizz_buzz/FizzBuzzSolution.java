package training.algorithms.fizz_buzz;

public interface FizzBuzzSolution {

    /**
     * For given number return:
     *  - Fizz if number can be divided by 3
     *  - Buzz if number can be divided by 5
     *  - FizzBuzz if number can be divided by 3 and 5
     *  - number if above conditions aren't met
     */
    String fizzBuzz(int number);

}
