package com.emeraldhieu.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSum {

    public int getCombinationCount(int x, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        process(combinations, combination, x, n);
        return combinations.size();
    }

    private State process(List<List<Integer>> allCombinations, List<Integer> combination,
                          int x, int n) {
        int sum = getSum(combination, n);

        if (sum > x) {
            removeLastElementIfExist(combination);
            removeLastElementIfExist(combination);
            return State.END_THE_LAYER;
        }

        if (sum == x) {
            allCombinations.add(new ArrayList<>(combination));
            combination.clear();
            return State.GO_TO_FIRST_LAYER;
        }

        for (int number = 1; number < x; ++number) {
            if (Math.pow(number, n) > x) { // Stop immediately if there's no chance to find a combination
                combination.clear();
                return State.GO_TO_FIRST_LAYER;
            }
            int previousNumber = combination.isEmpty() ? 0 : combination.get(combination.size() - 1);
            if (number <= previousNumber) { // Skip numbers that are less than the last number in the combination
                continue;
            }
            combination.add(number);
            State state = process(allCombinations, combination, x, n);
            if (state == State.END_THE_LAYER) {
                break;
            }
            if (state == State.GO_TO_FIRST_LAYER && previousNumber != 0) { // Get out of a layer until the first layer is encountered
                return State.GO_TO_FIRST_LAYER;
            }
        }
        return State.CONTINUE;
    }

    private void removeLastElementIfExist(List<Integer> combination) {
        if (!combination.isEmpty()) {
            combination.remove(combination.size() - 1);
        }
    }

    private int getSum(List<Integer> combination, int n) {
        return combination.stream()
            .mapToInt(value -> (int) Math.pow(value, n))
            .sum();
    }

    enum State {
        /**
         * Continue the flow as usual.
         */
        CONTINUE,

        /**
         * End the layer.
         */
        END_THE_LAYER,

        /**
         * Go back to the first layer of recursion.
         */
        GO_TO_FIRST_LAYER
    }
}
