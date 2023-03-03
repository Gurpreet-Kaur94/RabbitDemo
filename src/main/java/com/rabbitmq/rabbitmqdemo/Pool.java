package com.rabbitmq.rabbitmqdemo;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Pool {
    protected Object[] items;
    Pool(Object[] objects) {
        this.items = objects;
    }
    private static final int MAX_AVAILABLE = 5;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "ac before");
        available.acquire();
       // System.out.println(Thread.currentThread().getName() + "ac ");
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x))
            available.release();
    }

    // Not a particularly efficient data structure; just for demo



    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {

        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                System.out.println(Thread.currentThread().getName() + "get next " + items[i]);
//                for(int k = 0; k<100; k++)
//                    System.out.println(Thread.currentThread().getName());
                return items[i];

            }
        }
        return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }
}
