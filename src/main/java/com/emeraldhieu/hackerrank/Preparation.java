package com.emeraldhieu.hackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Preparation {

    public static void main(String[] args) {
//        var list = List.of(
//            List.of(11, 2, 4),
//            List.of(4, 5, 6),
//            List.of(10, 8, -12)
//        );
//        var diff = diagonalDifference(list);
//        System.out.println(diff);

//        var x = 42;
//        var y = 666;
//        double z = x / y;
//        var xD = BigDecimal.valueOf(x);
//        var yD = BigDecimal.valueOf(y);
//        var zD = xD.divide(yD, 6, RoundingMode.HALF_UP);
//        System.out.println(zD);

//        var str = Integer.toBinaryString(32);
//        var tokens = Arrays.asList(str.split("1"));
//        var counts = tokens.stream()
//            .filter(it -> !it.equals(""))
//            .map(it -> it.length())
//            .collect(Collectors.toList());
//        System.out.println(counts);
//
//        var max = counts.stream()
//            .max(Comparator.naturalOrder())
//                .orElse(0);

//        if (str.endsWith("0")) {
//            return 0;
//        }

//        System.out.println(max);

        //solution("[]");

//        solution(
//            List.of(4, 3, 2, 1, 5).stream().mapToInt(Integer::intValue).toArray(),
//            List.of(0, 1, 0, 0, 0).stream().mapToInt(Integer::intValue).toArray()
//        );

//        var test = solution(
//            "ca",
//            "ab"
//        );
//        var test = solution(
//            "abc",
//            "bcd"
//        );
//        var test = solution(
//            "axxz",
//            "yzwy"
//        );
        //System.out.println(test);

        solution(new int[]{4, 3, 4, 4, 4, 2});
    }

    public static int solution(int[] A) {
        var size = A.length;

        var equiLeaders = new ArrayList<Integer>();
        for (var i = 0; i < size - 1; ++i) {
            var occurrencesByValueOfFirstSequence = new HashMap<Integer, Integer>();
            for (var j = 0; j <= i; ++j) {
                var left = A[j];
                if (occurrencesByValueOfFirstSequence.containsKey(left)) {
                    var occurrences = occurrencesByValueOfFirstSequence.get(left);
                    var newOccurrences = occurrences + 1;
                    occurrencesByValueOfFirstSequence.put(left, newOccurrences);
                } else {
                    occurrencesByValueOfFirstSequence.put(left, 1);
                }
            }
            var mostOccurredElemOfFirstSequence = occurrencesByValueOfFirstSequence.entrySet().stream()
                .filter(entry -> entry.getValue() > occurrencesByValueOfFirstSequence.size() / 2)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);

            var occurrencesByValueOfSecondSequence = new HashMap<Integer, Integer>();
            for (var k = i + 1; k < size; ++k) {
                var right = A[k];
                if (occurrencesByValueOfSecondSequence.containsKey(right)) {
                    var occurrences = occurrencesByValueOfSecondSequence.get(right);
                    var newOccurrences = occurrences + 1;
                    occurrencesByValueOfSecondSequence.put(right, newOccurrences);
                } else {
                    occurrencesByValueOfSecondSequence.put(right, 1);
                }
            }
            var mostOccurredElemOfSecondSequence = occurrencesByValueOfSecondSequence.entrySet().stream()
                .filter(entry -> entry.getValue() > occurrencesByValueOfSecondSequence.size() / 2)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);

            if (mostOccurredElemOfFirstSequence == mostOccurredElemOfSecondSequence) {
                equiLeaders.add(mostOccurredElemOfFirstSequence);
            }
        }

        return equiLeaders.size();
    }

    public static int solution(String P, String Q) {
        var pChars = P.chars()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.toList());

        var qChars = Q.chars()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.toList());

        var pSize = pChars.size();
        var qSize = qChars.size();
        var size = pSize;

        var letters = new ArrayList<String>();
        var strings = new ArrayList<String>();
        for (int i = 0; i < pSize; ++i) {
            var pLetter = pChars.get(i);
            letters.add(pLetter);

            for (int j = 0; j < qSize; ++j) {
                var qLetter = qChars.get(j);
                letters.add(qLetter);
                if (letters.size() == size) {
                    strings.add(letters.stream().collect(Collectors.joining()));
                    letters.clear();
                    break;
                }

                int k = j + 1;
                if (k >= qSize) {
                    k = 0;
                }
                for (; k < qSize; ++k) {
                    var kLetter = qChars.get(k);
                    letters.add(kLetter);
                    if (letters.size() == size) {
                        strings.add(letters.toString());
                        break;
                    }
                }
            }
        }

        var distinctStrings = strings.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println(distinctStrings);

        return 42;
    }

    public static int solution(int[] A, int[] B) {
        var size = A.length;
        var aliveFishIndices = new ArrayList<Integer>();
        for (var i = 0; i < size; ++i) {
            aliveFishIndices.add(i);
        }

        for (var i = 0; i < size; ++i) {
            if (!aliveFishIndices.contains(i)) {
                continue;
            }
            var fishSize = A[i];
            var direction = B[i];
            if (direction == 1) {
                for (var j = i + 1; j < size; ++j) {
                    if (!aliveFishIndices.contains(j)) {
                        continue;
                    }
                    var otherFishSize = A[j];
                    var otherDirection = B[j];
                    if (otherDirection == 0) {
                        if (fishSize > otherFishSize) {
                            final var elemToRemove = j;
                            aliveFishIndices.removeIf(elem -> elem == elemToRemove);
                        } else if (fishSize < otherFishSize) {
                            final var elemToRemove = i;
                            aliveFishIndices.removeIf(elem -> elem == elemToRemove);
                            break;
                        }
                    }
                }
            }
        }

        return aliveFishIndices.size();
    }

    public static int solution(int N) {
        var str = Integer.toBinaryString(N);
        var size = str.length();
        var maxCount = 0;
        for (var i = 0; i < size; ++i) {
            var c = str.charAt(i);
            var digit = String.valueOf(c);
            if (digit.equals("0")) {
                var zeroCount = 1;
                var j = i + 1;
                for (; j < size; ++j) {
                    var zeroC = str.charAt(j);
                    var zeroDigit = String.valueOf(zeroC);
                    if (zeroDigit.equals("0")) {
                        ++zeroCount;
                        if (j == size - 1) { // Last elem is zero
                            i = j + 1;
                            break;
                        }
                    } else {
                        i = j + 1;
                        break;
                    }
                }
                if (zeroCount > maxCount && j != size - 1) { // Not the last elem
                    maxCount = zeroCount;
                }
            }
        }
        return maxCount;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        var width = 6;
        var height = 6;
        var values = arr.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        var size = values.size();

        var max = IntStream.range(0, size - 14)
            .mapToObj(i -> {
                var one = values.get(i);
                var two = values.get(i + 1);
                var three = values.get(i + 2);
                var four = values.get(i + 7);
                var five = values.get(i + 12);
                var six = values.get(i + 13);
                var seven = values.get(i + 14);
                return one + two + three + four + five + six + seven;
            })
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);

        return 42;
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        return IntStream.iterate(0, i -> i >= 0, i -> --i)
            .mapToObj(i -> a.get(i))
            .collect(Collectors.toList());
    }

    private static BigDecimal get(int x, int y) {
        var xD = BigDecimal.valueOf(x);
        var yD = BigDecimal.valueOf(y);
        return xD.divide(yD, 6, RoundingMode.HALF_UP);
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        assert a.size() == b.size() : "Sizes must be equal";

        int aliceWins = (int) IntStream.range(0, a.size())
            .filter(i -> a.get(i) > b.get(i))
            .count();

        int bobWins = (int) IntStream.range(0, a.size())
            .filter(i -> b.get(i) > a.get(i))
            .count();

        return List.of(aliceWins, bobWins);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        var leftDiagonalSum = IntStream.range(0, size)
            .mapToObj(i -> arr.get(i).get(i))
            .reduce(0, Integer::sum);

        var rightDiagonalSum = IntStream.range(0, size)
            .mapToObj(i -> arr.get(i).get(size - 1 - i))
            .reduce(0, Integer::sum);

        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }

}
