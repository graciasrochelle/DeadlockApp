package com.deadlock;

public class ThreadDeadlock {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public ThreadDeadlock(){
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println(Thread.currentThread().getName() + ":ThreadDeadLock: Holding lock 1...");

                Util.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":ThreadDeadLock: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println(Thread.currentThread().getName() + ":ThreadDeadLock: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock2) {
                System.out.println(Thread.currentThread().getName() + ":ThreadDeadLock: Holding lock 2...");

                Util.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":ThreadDeadLock: Waiting for lock 1...");

                synchronized (Lock1) {
                    System.out.println(Thread.currentThread().getName() + ":ThreadDeadLock: Holding lock 1 & 2...");
                }
            }
        }
    }
}

