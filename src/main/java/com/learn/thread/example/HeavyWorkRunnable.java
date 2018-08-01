package com.learn.thread.example;

public class HeavyWorkRunnable implements Runnable {
    private int x  = 0;
    @Override
    public void run() {
        x ++;
        System.out.println("Doing heavy processing - START " + x + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing heavy processing - END " + Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }

}