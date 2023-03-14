package com.emeraldhieu.recursion;

public class Palindrome {

    public boolean isPalindrome(String input) {
        if (input.isEmpty() || input.length() == 1) {
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }
}
