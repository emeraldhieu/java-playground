package com.emeraldhieu.recursion;

public class Fibonacci {

    public long findNthFibonacci(long n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }
}
