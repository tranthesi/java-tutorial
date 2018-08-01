package com.learn.thread.example;

public class ThreadRunExample {

    public static void main(String[] args) {
        System.out.println("Starting Runnable threads");
        Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        t1.start();
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
        t2.start();
        System.out.println("Runnable Threads has been started");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
        System.out.println("Starting MyThreads");
        t3.start();
        t4.start();
        System.out.println("MyThreads has been started");

    }
}
