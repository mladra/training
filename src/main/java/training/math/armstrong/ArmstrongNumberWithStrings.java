package training.math.armstrong;

import training.utils.TrainingUtils;

import java.util.Objects;
import java.util.stream.IntStream;

class ArmstrongNumberWithStrings implements ArmstrongNumberChecker {

    @Override
    public boolean isArmstrongNumber(int number) {
        int armstrong = calculateArmstrong(number);
        return armstrong == number;
    }

    private int calculateArmstrong(int number) {
        char[] charArray = String.valueOf(number).toCharArray();
        return IntStream.range(0, charArray.length)
                .mapToObj(idx -> charArray[idx])
                .map(Objects::toString)
                .mapToInt(Integer::valueOf)
                .map(digit -> TrainingUtils.pow(digit, charArray.length))
                .sum();
    }

}
