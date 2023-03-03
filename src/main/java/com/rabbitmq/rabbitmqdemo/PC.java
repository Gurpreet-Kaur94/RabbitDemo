package com.rabbitmq.rabbitmqdemo;

import java.util.List;

public class PC {

    private int size;
    private List<Integer> list;

    public PC(int size, List<Integer> list) {
        this.size = size;
        this.list = list;
    }

    public synchronized void produce() {
        System.out.println("Producing");
        int value = 0;
        while(true) {
            //synchronized (this) {
                try {
                    if (list.size() == 1) {
                        System.out.println("P wait");
                        wait();
                    }
                } catch (InterruptedException e) {

                }
                value += 1;
                list.add(value);
                System.out.println(value + "Produced");
                consume();
                notify();
            }
        //}
    }

    public synchronized void  consume() {
        System.out.println("Consuming");
        while(true) {
           // synchronized (this) {
                try {
                    if (list.size() == 0) {
                        System.out.println("Co wait");
                        wait();
                    }
                } catch (InterruptedException e) {

                }
                int value = list.remove(0);
                System.out.println(value + "Consumed");
                notify();
           // }
        }
    }
}
