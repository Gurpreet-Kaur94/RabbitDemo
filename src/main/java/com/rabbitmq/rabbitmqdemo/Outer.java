package com.rabbitmq.rabbitmqdemo;

public class Outer {
        private int x;

        public void f() {
            Inner inner = new Inner();
            inner.g();
            inner.y = 5;
            System.out.println(inner.y);
            try {
                throw new NullPointerException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array bound");
            } finally {
                System.out.println("Fianlly Occured");
            }
        }

        protected class Inner {
            protected int y;

            public void g() { x = 5; }
        }
    }

