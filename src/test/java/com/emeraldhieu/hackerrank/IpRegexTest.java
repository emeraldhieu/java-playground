package com.emeraldhieu.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IpRegexTest {

    private final IpRegex ipRegex = new IpRegex();

    @Test
    public void allIps() {
        // GIVEN
        Map<String, Boolean> ips = Map.of(
            "000.12.12.034", true,
            "121.234.12.12", true,
            "23.45.12.56", true,
            "0000.00.00.00", false,
            "000.12.234.23.23", false,
            "666.666.23.23", false,
            ".213.123.23.32", false,
            "23.45.22.32.", false,
            "I.Am.not.an.ip", false
        );

        ips.entrySet().forEach(ip -> {
            // WHEN
            boolean result = ip.getKey().matches(ipRegex.getPattern());

            // THEN
            assertEquals(ip.getValue(), result);
        });
    }
}