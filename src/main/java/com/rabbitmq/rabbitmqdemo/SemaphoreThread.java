package com.rabbitmq.rabbitmqdemo;

import java.util.concurrent.Semaphore;

public class SemaphoreThread {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Thread t1  = new Thread(() -> {
            System.out.println("Starting Thread 1");
            try {

                semaphore.acquire(2) ;
                System.out.println("Lock acquired by T1");
                System.out.println("T1   " +semaphore.availablePermits());
                long i = 0;
                while( i < 100000000000l) {
                    i += 1;
                }
            } catch (InterruptedException e) {

            }
            semaphore.release(2);
            System.out.println("T1   " +semaphore.availablePermits());
            System.out.println("Lock released by T1");
        });

        Thread t2  = new Thread(() -> {
            System.out.println("Starting Thread 2");

            try {
                System.out.println("T2  before acquire " +semaphore.availablePermits());
                semaphore.acquire(1) ;

                System.out.println("Lock acquired by T2");
                System.out.println("T2   " +semaphore.availablePermits());

            } catch (InterruptedException e) {

            }
            semaphore.release(1);
            System.out.println("Lock released by by T2");
        });

        Thread t3  = new Thread(() -> {
            System.out.println("Starting Thread 3");
            System.out.println("T3  before release " + semaphore.availablePermits());
            try {

                semaphore.acquire(1) ;


            } catch (InterruptedException e) {

            }
            semaphore.release(1); ;
            System.out.println("Lock released by by 3");
            System.out.println("T3  after release " + semaphore.availablePermits());

        });

        t1.start();
        t3.start();
        t2.start();
    }
}
