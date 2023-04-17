package com.emeraldhieu.hackerrank;

import java.util.List;
import java.util.Map;

public class TheTimeInWords {

    private final Map<Integer, String> WORDS_BY_ONE_DIGIT = Map.of(
        1, "one",
        2, "two",
        3, "three",
        4, "four",
        5, "five",
        6, "six",
        7, "seven",
        8, "eight",
        9, "nine"
    );

    private final Map<Integer, String> WORDS_BY_TWO_DIGIT = Map.of(
        10, "ten",
        11, "eleven",
        12, "twelve",
        13, "thirteen",
        14, "fourteen",
        15, "fifteen",
        16, "sixteen",
        17, "seventeen",
        18, "eighteen",
        19, "nineteen"
    );

    private final Map<Integer, String> WORDS_BY_MULTIPLE_OF_TEN_DIGIT = Map.of(
        20, "twenty",
        30, "thirty",
        40, "forty",
        50, "fifty"
    );

    private final String QUARTER = "quarter";
    private final String HALF = "half";

    public String timeInWords(int hour, int minute) {
        if (hour < 1 || hour > 12 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid hour and minute");
        }

        // Process minutes first
        String minuteWord = getMinuteWord(minute);
        String minutePhrase = getMinutePhrase(minuteWord);

        // Process the connection word e.g. "to", "past"
        String connectionWord = getConnectionWord(minute);
        String connectionPhrase = getConnectionPhrase(connectionWord);

        // Process the hour
        String hourWord = getHourWord(hour, minute);
        String hourPhrase = getHourPhrase(hourWord, minuteWord);

        // Process the word "o'clock"
        String oclock = getOclock(minuteWord);

        // Combine them all
        String timeWord = minutePhrase + connectionPhrase + hourPhrase + oclock;

        // Standardize the time word;
        return standardizeWord(timeWord);
    }

    private String getMinuteWord(int minute) {
        if (minute == 0) {
            return "";
        }
        if (minute > 0 && minute < 10) {
            return getWordForOneDigit(minute);
        }
        if (minute > 9 && minute < 20) {
            if (minute == 15) {
                return QUARTER;
            }
            return getWordForTwoDigit(minute);
        }
        if (minute > 19 && minute < 30) {
            return getMultipleOfTenMinuteWord(minute);
        }
        if (minute == 30) {
            return HALF;
        }
        if (minute > 30 && minute < 60) {
            int complement = 60 - minute;
            // Recursively get minute for the complement
            return getMinuteWord(complement);
        }
        throw new IllegalArgumentException("Invalid minute input");
    }

    private String getMultipleOfTenMinuteWord(int minute) {
        if (minute % 10 != 0) {
            int remainder = minute % 10;
            int minuteWithoutRemainder = minute - remainder;
            String multipleOfTenWord = getWordForMultipleOfTen(minuteWithoutRemainder);
            String oneDigitWord = getWordForOneDigit(remainder);
            return String.format("%s %s", multipleOfTenWord, oneDigitWord);
        }
        return getWordForMultipleOfTen(minute);
    }

    private String getMinutePhrase(String word) {
        if (word.isEmpty()) {
            return "";
        }
        if (List.of(QUARTER, HALF).contains(word)) {
            return word + " ";
        }
        if (word.equals("one")) {
            return word + " minute ";
        }
        return word + " minutes ";
    }

    private String getConnectionWord(int minute) {
        if (minute == 0) {
            return "";
        }
        if (minute < 31) {
            return "past";
        }
        return "to";
    }

    private String getConnectionPhrase(String word) {
        if (word.isEmpty()) {
            return "";
        }
        return word + " ";
    }

    private String getHourWord(int hour, int minute) {
        int shiftedHour = minute > 30 ? hour + 1 : hour;
        if (shiftedHour > 0 && shiftedHour < 10) {
            return getWordForOneDigit(shiftedHour);
        }
        if (shiftedHour > 9 && shiftedHour < 13) {
            return getWordForTwoDigit(shiftedHour);
        }
        throw new IllegalArgumentException("Invalid hour input");
    }

    private String getHourPhrase(String hourWord, String minute) {
        if (minute.isEmpty()) {
            return hourWord + " ";
        }
        return hourWord;
    }

    private String getWordForOneDigit(int digit) {
        // 1, 2, 3, ..., 9
        return WORDS_BY_ONE_DIGIT.get(digit);
    }

    private String getWordForTwoDigit(int digit) {
        // 10, 11, 12, ..., 19
        return WORDS_BY_TWO_DIGIT.get(digit);
    }

    private String getWordForMultipleOfTen(int digit) {
        // 20, 30, 40, ... 50
        return WORDS_BY_MULTIPLE_OF_TEN_DIGIT.get(digit);
    }

    private String getOclock(String minuteWord) {
        if (minuteWord.isEmpty()) {
            return "o'clock";
        }
        return "";
    }

    private String standardizeWord(String word) {
        String upperCaseWord = word.substring(0, 1).toUpperCase();
        String lowercaseWord = word.substring(1).toLowerCase();
        return upperCaseWord + lowercaseWord;
    }
}
