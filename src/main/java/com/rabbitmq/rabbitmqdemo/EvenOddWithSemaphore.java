package com.rabbitmq.rabbitmqdemo;

import java.util.concurrent.Semaphore;

public class EvenOddWithSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() -> {

            int value = 1;
            while(value <= 10) {
                try {
                    semaphore.acquire(1);
                    System.out.println(value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value += 2;
            }
        });

        Thread t2 = new Thread(() -> {
            int value = 2;
            while(value <= 10) {
                System.out.println(value);
                semaphore.release(1);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value += 2;
            }
        });

        t1.start();
        t2.start();
    }
}
