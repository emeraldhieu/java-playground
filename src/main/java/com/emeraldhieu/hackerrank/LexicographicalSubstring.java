package com.emeraldhieu.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LexicographicalSubstring {

    public String getSmallestAndLargest(String s, int k) {
        if (!s.matches("[a-zA-Z]+") || k < 0 || k > 1000) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        List<String> substrings = new ArrayList<>();
        for (int i = 0; i <= s.length() - k; ++i) {
            String substring = s.substring(i, i + k);
            substrings.add(substring);
        }

        List<String> sortedSubString = substrings.stream()
            .sorted()
            .collect(Collectors.toList());

        String smallest = sortedSubString.get(0);
        String largest = sortedSubString.get(sortedSubString.size() - 1);

        return smallest + "\n" + largest;
    }
}
