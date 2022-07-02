package com.emeraldhieu.concurrency.synchronization;

public class A {

    private static Object object = new Object();

    // ========================== Use class instance to synchronize ============================ //

//    public synchronized void a() {
//        for (int i = 0; i < 10; ++i) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
//        }
//    }
//
//    public synchronized void b() {
//        for (int i = 0; i < 10; ++i) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
//        }
//    }

    // ========================== Use a dedicated object to synchronize ============================ //

    public void a() {
        synchronized (object) {
            for (int i = 0; i < 10; ++i) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
            }
        }
    }

    public void b() {
        synchronized (object) {
            for (int i = 0; i < 10; ++i) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
            }
        }
    }
}
