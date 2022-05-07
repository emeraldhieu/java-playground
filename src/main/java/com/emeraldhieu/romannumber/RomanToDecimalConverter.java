package com.emeraldhieu.romannumber;

import java.util.Arrays;
import java.util.List;

public class RomanToDecimalConverter {

    public int convert(String romanNumber) {

        /**
         * I don't use a map because unmodifiable map doesn't maintain order of entries.
         * Of course, I can use LinkedHashMap to do that, but it's not a good solution.
         * I'd prefer using a named class {@link BasicNumber}.
         */
        List<BasicNumber> list = Arrays.asList(
            new BasicNumber("I", 1),
            new BasicNumber("V", 5),
            new BasicNumber("X", 10),
            new BasicNumber("L", 50),
            new BasicNumber("C", 100),
            new BasicNumber("D", 500),
            new BasicNumber("M", 1000)
        );

        List<String> letters = Arrays.asList(romanNumber.split(""));

        int resultNumber = 0;

        String previousLetter = "";
        for (int i = 0; i < letters.size(); ++i) {
            String letter = letters.get(i);
            int number = getNumber(list, letter);

            resultNumber += number;

            if (!previousLetter.isEmpty()) {
                int previousNumber = getNumber(list, previousLetter);
                if (previousNumber < number) {
                    resultNumber = resultNumber - previousNumber - previousNumber;
                }
            }

            previousLetter = letter;
        }

        return resultNumber;
    }

    private int getNumber(List<BasicNumber> list, String letter) {
        int number = list.stream()
            .filter(basicNumber -> basicNumber.getRomanNumber().equals(letter))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Something wrong"))
            .getDecimalNumber();
        return number;
    }
}
