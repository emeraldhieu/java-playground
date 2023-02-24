package com.emeraldhieu.concurrency.racecondition;

import java.util.HashMap;
import java.util.Map;

class CheckThenActFix {
    private final Map<String, String> sharedMap = new HashMap<>();

    public void checkThenAct() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            if (sharedMap.containsKey("key")) {
                String value = sharedMap.remove("key");
                if (value == null) {
                    System.out.println("value is null");
                }
            } else {
                sharedMap.put("key", "value");
            }
        }
    }

    public static void main(String[] args) {
        CheckThenActFix checkThenAct = new CheckThenActFix();
        for (int i = 0; i < 100; ++i) {
            Runnable r1 = () -> checkThenAct.checkThenAct();
            new Thread(r1).start();

            Runnable r2 = () -> checkThenAct.checkThenAct();
            new Thread(r2).start();
        }
    }
}
