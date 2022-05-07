package com.emeraldhieu.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /**
     * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that 
     * mark the boundaries of the range which is maped to other bin range properties such
     * as a card type. The range boundaries are inclusive.
     */
    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }        
    }

    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         * 
         * @return the card type for this cardNumber or null if the card number does not
         *      fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }
    
    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     *
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        // TODO return a new instance of CardTypeCache
        return null;
    }
    
    public static class MyCache implements CardTypeCache {

        private final NavigableMap<String, BinRange> map = new TreeMap<>();
        private final NavigableMap<String, BinRange> map2 = new TreeMap<>();
        private final Map<String, String> map3 = new HashMap<>();

        public MyCache(List<BinRange> binRanges) {
            binRanges.stream().forEach(binRange -> {
                map.put(binRange.start, binRange);
                map2.put(binRange.end, binRange);
                map3.put(binRange.start, binRange.end);
            });
        }

        @Override
        public String get(String cardNumber) {
            String binToCheck = cardNumber.substring(0, 12);

            String floorKey = map.floorKey(binToCheck);
            if (floorKey == null) {
                return null;
            }
            if (!map.containsKey(floorKey)) {
                return null;
            }

            String ceilingKey = map2.ceilingKey(binToCheck);
            if (ceilingKey == null) {
                return null;
            }
            if (!map2.containsKey(ceilingKey)) {
                return null;
            }

            if (map3.get(floorKey).equals(ceilingKey)) {
                return map.get(floorKey).cardType;
            }

            return null;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Result.BinRange> binRanges = Arrays.asList(
            new Result.BinRange("400000000000", "419999999999", "visa"),
            new Result.BinRange("420008000000", "420008999999", "visadebit"),
            new Result.BinRange("435000000000", "435000999999", "something"),
            new Result.BinRange("540000000000", "599999999999", "mc")
        );

                String cardNumber = "420008999999";
//        String cardNumber = "435000999998";
//        String cardNumber = "435000000000";
//        String cardNumber = "436000999999";
//        String cardNumber = "990000000000";
        Result.MyCache myCache = new Result.MyCache(binRanges);
        String result = myCache.get(cardNumber);
        //System.out.println(result);

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        try (final Scanner scanner = new Scanner(System.in)) {
//            List<Result.BinRange> binRanges = new ArrayList<>();
//
//            String cardNumber = scanner.next();
//            scanner.nextLine();
//
//            scanner.useDelimiter("[,\n]");
//
//            while (scanner.hasNext()) {
//                String start = scanner.next();
//                String end = scanner.next();
//                String cardType = scanner.next();
//                binRanges.add(new Result.BinRange(start, end, cardType));
//                if (scanner.hasNextLine()) {
//                    scanner.nextLine();
//                }
//            }
//
//            Result.CardTypeCache cache = Result.buildCache(binRanges);
//            if (cache != null) {
//                bufferedWriter.write(String.valueOf(cache.get(cardNumber)));
//            }
//        }
//
//        bufferedWriter.newLine();
//        bufferedWriter.close();
    }
}