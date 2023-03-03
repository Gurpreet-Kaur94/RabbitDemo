package com.rabbitmq.rabbitmqdemo;

import java.util.ArrayList;
import java.util.List;

public class ObjectLevelLock {

    public  static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        PC pc1 = new PC(2, list1);
        new Thread(() -> {
            pc1.produce();
        }).start();

       // list1.add(100);
        /*new Thread(() -> {
            pc1.consume();
        }).start();*/


    }
}
