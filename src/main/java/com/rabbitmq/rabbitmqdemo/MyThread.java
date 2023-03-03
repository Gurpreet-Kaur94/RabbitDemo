package com.rabbitmq.rabbitmqdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThread {

    public static void  main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable thread = () -> {
            System.out.println(Thread.currentThread().getName()+" Start. Command = ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" End.");
        };

        for(int i = 0; i < 10; i++)
            executorService.execute(thread);

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all threads");

      executorService = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
              new ArrayBlockingQueue<Runnable>(5));

    }



}
