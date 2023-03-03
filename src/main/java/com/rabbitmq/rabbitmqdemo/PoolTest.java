package com.rabbitmq.rabbitmqdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {

    public static void main(String[] args) {
        Integer[] items = new Integer[5];
        for(int i = 0; i < 5; i++) {
            items[i] = i +1;
        }
        Pool pool = new Pool(items);
        ExecutorService executor = Executors.newFixedThreadPool(7);
        for(int i = 0; i < 7; i++){
            executor.execute(() -> {
            //    System.out.println(Thread.currentThread().getName() );
                int value = 5;
                try {
                    System.out.println( pool.getItem());
                } catch (InterruptedException e) {

                }
//                int j  =0;
//                while(j < 100000) {
//                    j += 1;
//                }
               // pool.putItem(value);
              //  System.out.println(Thread.currentThread().getName() + "put  ");
            });
        }
    }

}
