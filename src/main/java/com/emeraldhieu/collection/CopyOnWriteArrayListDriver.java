package com.emeraldhieu.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDriver {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers
            = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});

        Iterator<Integer> iterator = numbers.iterator();

        numbers.add(10);

        System.out.println(numbers);

        iterator.forEachRemaining(integer -> {
            numbers.remove(integer);
        });

        System.out.println(numbers);
    }
}
