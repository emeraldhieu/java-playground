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

    /**
     * @deprecated because String#split is slow.
     */
    @Deprecated
    public boolean isAnagramDeprecated(String stringToCheck) {
        List<String> sortedCharactersOfString = getSortedCharacters(string);
        List<String> sortedCharactersOfStringToCheck = getSortedCharacters(stringToCheck);
        return sortedCharactersOfString.equals(sortedCharactersOfStringToCheck);
    }

    private List<String> getSortedCharacters(String str) {
        return Arrays.asList(str.split("")).stream()
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.toList());
    }

    public boolean isAnagram(String stringToCheck) {
        String sortedString = getStringWithSortedCharacters(string);
        String sortedStringToCheck = getStringWithSortedCharacters(stringToCheck);
        return sortedString.equals(sortedStringToCheck);
    }

    private String getStringWithSortedCharacters(String str) {
        int[] cookedCodepoints = str.codePoints()
            .map(Character::toLowerCase)
            .sorted()
            .toArray();
        return new String(cookedCodepoints, 0, cookedCodepoints.length);
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
