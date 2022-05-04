package com.emeraldhieu.hackerrank;

public class Driver {
    public static void main(String[] args) {
        String s = "something";

        int len = s.length();
        int offset = 0;

        while (offset < len) {
            int curChar = s.codePointAt(offset);
            int charCount = Character.charCount(curChar);
            offset += charCount;

            System.out.println((char) curChar);
        }
    }
}
