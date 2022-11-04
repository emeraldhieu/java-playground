package com.emeraldhieu.hackerrank;

import java.util.Scanner;

public class StringFollowedByNumberReader {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int i = scan.nextInt();
            double d = scan.nextDouble();

            /**
             * Skip the break line coming after the double.
             * See https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo#7056782
             */
            scan.nextLine();

            String s = scan.nextLine();

            System.out.println("String: " + s);
            System.out.println("Double: " + d);
            System.out.println("Int: " + i);
        }
    }
}