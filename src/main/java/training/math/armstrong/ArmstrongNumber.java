package training.math.armstrong;

import training.utils.TrainingUtils;

import java.util.Stack;

class ArmstrongNumber implements ArmstrongNumberChecker {

    @Override
    public boolean isArmstrongNumber(int number) {
        Stack<Integer> digits = new Stack<>();

        int internalNumber = number;
        while (internalNumber > 0) {
            int digit = internalNumber % 10;
            digits.add(digit);
            internalNumber -= digit;
            internalNumber /= 10;
        }

        int digitsCount = digits.size();
        int sum = 0;
        while (!digits.isEmpty()) {
            int digit = digits.pop();
            sum += TrainingUtils.pow(digit, digitsCount);
        }

        return sum == number;
    }
}
