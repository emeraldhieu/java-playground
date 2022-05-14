package com.emeraldhieu.cardtypecache;

/**
 * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that
 * mark the boundaries of the range which is maped to other bin range properties such
 * as a card type. The range boundaries are inclusive.
 */
final class BinRange {
    final String start;
    final String end;
    final String cardType;

    BinRange(String start, String end, String cardType) {
        this.start = start;
        this.end = end;
        this.cardType = cardType;
    }
}