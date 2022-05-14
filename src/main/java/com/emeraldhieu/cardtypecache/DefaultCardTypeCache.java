package com.emeraldhieu.cardtypecache;

import java.util.*;

class DefaultCardTypeCache implements CardTypeCache {

    private final NavigableMap<Long, BinRange> map = new TreeMap<>();
    private final NavigableMap<Long, BinRange> map2 = new TreeMap<>();
    private final Map<Long, Long> map3 = new HashMap<>();

    public DefaultCardTypeCache(List<BinRange> binRanges) {
        binRanges.stream().forEach(binRange -> {
            map.put(Long.parseLong(binRange.start), binRange);
            map2.put(Long.parseLong(binRange.end), binRange);
            map3.put(Long.parseLong(binRange.start), Long.parseLong(binRange.end));
        });
    }

    @Override
    public String get(String cardNumber) {
        String binToCheck = cardNumber.substring(0, 12);

        Long floorKey = map.floorKey(Long.parseLong(binToCheck));
        if (floorKey == null) {
            return null;
        }
        if (!map.containsKey(floorKey)) {
            return null;
        }

        Long ceilingKey = map2.ceilingKey(Long.parseLong(binToCheck));
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