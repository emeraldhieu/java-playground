package com.emeraldhieu.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class to determine if two strings are anagram of each other.
 */
public class Anagram {

    private final String string;

    //private final Pattern pattern = Pattern.compile("\\p{Punct}");

    public Anagram(String string) {
        this.string = string;
    }

    public boolean isAnagram(String stringToCheck) {
        List<String> sortedTokens = Arrays.asList(string.split("")).stream()
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.toList());

        List<String> sortedTokensToCheck = Arrays.asList(stringToCheck.split("")).stream()
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.toList());

        return sortedTokens.equals(sortedTokensToCheck);
    }

    /*
    public boolean isPunctuation(int ch) {
        if (pattern.matcher(String.valueOf((char) ch)).matches()) {
            return true;
        }
        return false;
    }
     */
}
