package com.emeraldhieu.recursion;

public class StringReversal {

    public String reverseString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public String reverseStringWithDifferentStoppingCondition(String input) {
        if (input.length() == 1) {
            return input;
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
