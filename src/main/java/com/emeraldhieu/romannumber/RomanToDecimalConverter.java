package com.emeraldhieu.romannumber;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RomanToDecimalConverter {

    private static final Map<String, Integer> decimalNumbersByRomanLetter = Map.of(
        "I", 1,
        "V", 5,
        "X", 10,
        "L", 50,
        "C", 100,
        "D", 500,
        "M", 1000
    );

    public int convert(String romanNumber) {
        List<String> letters = Arrays.asList(romanNumber.split(""));
        int resultNumber = 0;
        String previousLetter = "";

        for (int i = 0; i < letters.size(); ++i) {
            String letter = letters.get(i);
            int number = decimalNumbersByRomanLetter.get(letter);

            resultNumber += number;

            if (!previousLetter.isEmpty()) {
                int previousNumber = decimalNumbersByRomanLetter.get(previousLetter);
                if (previousNumber < number) {
                    resultNumber = resultNumber - previousNumber - previousNumber;
                }
            }

            previousLetter = letter;
        }

        return resultNumber;
    }
}
