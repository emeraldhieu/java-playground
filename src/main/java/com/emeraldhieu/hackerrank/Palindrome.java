package com.emeraldhieu.hackerrank;

/**
 * A class to determine if a string is a palindrome.
 */
public class Palindrome {

    public boolean check(String string) {
        StringBuilder sb = new StringBuilder(string);
        StringBuilder reversedString = sb.reverse();
        if (string.equals(reversedString.toString())) {
            return true;
        }
        return false;
    }
}
