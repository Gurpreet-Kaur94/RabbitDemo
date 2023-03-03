package com.rabbitmq.rabbitmqdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerConsumerWithSemaphore {
    static Semaphore semaphore = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    static List<String> list = new ArrayList<>();

    static class Producer implements Runnable{

        public void run() {

            String threadName = Thread.currentThread().getName();
            int count = 0;
            while (true) {
                try {
                    mutex.acquire(1);
                    list.add(threadName + count++);

                } catch (InterruptedException e) {

                }
                mutex.release(1);
            semaphore.release(1);
        }

        }
    }

    static class Consumer implements Runnable{

        public void run() {

            try {
                semaphore.acquire();
                mutex.acquire(1);

                for(String l : list) {
                    System.out.print(l + " ");
                }
                System.out.println();

                mutex.release(1);
            } catch (InterruptedException e) {

            }
            //semaphore.release(1);

        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer(),  "Hello").start();
        new Thread(new Consumer(), "Hi").start();
        new Thread(new Consumer(), "Bye").start();
    }


}
