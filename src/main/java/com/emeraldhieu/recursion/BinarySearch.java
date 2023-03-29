package com.emeraldhieu.recursion;

import java.util.List;

public class BinarySearch {

    /**
     * Mind that the given list has to be ordered.
     */
    public int search(List<Integer> numbers, int searchedNumber) {
        return search(numbers, 0, numbers.size() - 1, searchedNumber);
    }

    private int search(List<Integer> numbers, int leftIndex, int rightIndex, int searchedNumber) {
        if (leftIndex > rightIndex) {
            return -1;
        }

        int midIndex = (leftIndex + rightIndex) / 2;
        int midNumber = numbers.get(midIndex);

        if (searchedNumber < midNumber) {
            return search(numbers, leftIndex, midIndex - 1, searchedNumber);
        }

        if (searchedNumber > midNumber) {
            return search(numbers, midIndex + 1, rightIndex, searchedNumber);
        }

        return midIndex;
    }
}
