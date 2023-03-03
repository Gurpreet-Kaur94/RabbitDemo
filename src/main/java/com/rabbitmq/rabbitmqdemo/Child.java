package com.rabbitmq.rabbitmqdemo;

import java.sql.SQLDataException;

public class Child{

    void method() throws SQLDataException {
        System.out.println("child");
    }

    void method(String s) throws RuntimeException {
        System.out.println("child");
    }
}
