package com.twu.refactoring;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return counter(number -> number % 2 == 0);

    }

    public int countOdd() {
        return counter(number -> number % 2 != 0);
    }

    public int countPositive() {
        return counter(number -> number >= 0);
    }

    public int countNegative() {
        return counter(number -> number < 0);
    }

    private int counter(IntPredicate predicate) {
        return (int) Arrays.stream(numbers).filter(predicate).count();
    }
}
