package com.emeraldhieu.cardtypecache;

import java.util.*;

class DefaultCardTypeCache implements CardTypeCache {

    private final NavigableMap<String, BinRange> map = new TreeMap<>();
    private final NavigableMap<String, BinRange> map2 = new TreeMap<>();
    private final Map<String, String> map3 = new HashMap<>();

    public DefaultCardTypeCache(List<BinRange> binRanges) {
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