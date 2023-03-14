package com.emeraldhieu.recursion;

public class SumOfNaturalNumber {

    public int sum(int number) {
        if (number == 0) {
            return 0;
        }
        return number + sum(number - 1);
    }
}
