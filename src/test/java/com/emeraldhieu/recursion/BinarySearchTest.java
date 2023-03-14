package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private BinarySearch binarySearch = new BinarySearch();
    private List<Integer> numbers = List.of(-1, 0, 1, 2, 3, 4, 7, 9, 10, 20);

    @Test
    public void searchTen() {
        // GIVEN
        int item = 10;

        // WHEN
        int index = binarySearch.search(numbers, item);

        // THEN
        assertEquals(8, index);
    }

    @Test
    public void searchTwo() {
        // GIVEN
        int item = 2;

        // WHEN
        int index = binarySearch.search(numbers, item);

        // THEN
        assertEquals(3, index);
    }

    @Test
    public void searchThree() {
        // GIVEN
        int item = 3;

        // WHEN
        int index = binarySearch.search(numbers, item);

        // THEN
        assertEquals(4, index);
    }

    @Test
    public void searchFortyTwo() {
        // GIVEN
        int item = 42;

        // WHEN
        int index = binarySearch.search(numbers, item);

        // THEN
        assertEquals(-1, index);
    }
}