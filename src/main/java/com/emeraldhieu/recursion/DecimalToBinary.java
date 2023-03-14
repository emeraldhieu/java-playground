package com.emeraldhieu.recursion;

public class DecimalToBinary {

    public String convertToBinary(int number) {
        if (number == 0) {
            return "";
        }
        int remainder = number % 2;
        return convertToBinary(number / 2) + remainder;
    }
}
