package com.emeraldhieu.interview;

public class BasicNumber {
    private final String romanNumber;
    private final int decimalNumber;

    public BasicNumber(String roman, int decimal) {
        this.romanNumber = roman;
        this.decimalNumber = decimal;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }
}