package com.emeraldhieu.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListDriver {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 5, 8));

        Iterator<Integer> iterator = numbers.iterator();

        numbers.add(10);

        /**
         * ConcurrentModification because the list has been modified so the iterator is affected.
         */
        while (iterator.hasNext()) {
            iterator.next();
        }
    }
}
