package training.algorithms.fizz_buzz;

class FizzBuzzStringImpl implements FizzBuzzSolution {

    @Override
    public String fizzBuzz(int number) {
        String result = "";

        if (number % 3 == 0) {
            result += "Fizz";
        }

        if (number % 5 == 0) {
            result += "Buzz";
        }

        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
