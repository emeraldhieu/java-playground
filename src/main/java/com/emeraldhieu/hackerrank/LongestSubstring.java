package com.emeraldhieu.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Examples:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ---
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * ---
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ---
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * ---
 * See https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        var chars = s.codePoints().toArray();
        var visitedChars = new ArrayList<Integer>();
        var lengthsBySubstring = new HashMap<String, Integer>();

        for (int i = 0; i < chars.length; ++i) {
            for (int j = i; j < chars.length; ++j) {
                int ch = chars[j];
                if (!visitedChars.contains(ch)) {
                    visitedChars.add(ch);
                } else {
                    String substring = getString(visitedChars);
                    lengthsBySubstring.putIfAbsent(substring, substring.length());
                    visitedChars.clear();
                    break;
                }
            }

            if (!visitedChars.isEmpty()) {
                String substring = getString(visitedChars);
                lengthsBySubstring.putIfAbsent(substring, substring.length());
            }
        }

        var entryWithMaxValue = lengthsBySubstring.entrySet().stream()
            .max((o1, o2) -> o1.getValue() > o2.getValue() ? 1 :
                o1.getValue() == o2.getValue() ? 0 : -1)
            .get();

        return entryWithMaxValue.getValue();
    }

    private String getString(ArrayList<Integer> codepoints) {
        return codepoints.stream()
            .mapToInt(Integer::intValue)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
