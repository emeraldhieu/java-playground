package com.emeraldhieu.concurrency.synchronization;

public class Driver {

    public static void main(String[] args) {
        A a = new A();

        Runnable r1 = () -> a.a();
        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = () -> a.b();
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
