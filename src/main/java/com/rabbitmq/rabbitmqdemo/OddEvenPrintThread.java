package com.rabbitmq.rabbitmqdemo;


public class OddEvenPrintThread {
    public static void main(String[] args) {
        Producer p = new OddEvenPrintThread().new Producer();

        Thread t1 = new Thread(() -> {
                p.printOdd();
        });

        Thread t2 = new Thread(() -> {
            p.printEven();
        });

        t1.start();
        t2.start();
    }

     class Producer{
        boolean isEven;
        Producer() {
            this.isEven = false;
        }

        public  void printOdd() {

                synchronized (this) {
                    int value = 1;
                    while(value <= 10) {
                    if (isEven) {
                        try {
                            wait();
                        } catch (InterruptedException e) {

                        }
                    }
                    System.out.println(value);
                    isEven = true;
                    notify();
                    value += 2;
                }

            }
        }

         public  void printEven() {

                 synchronized (this) {
                     int value = 2;
                     while (value <= 10) {
                     if (!isEven) {
                         try {
                             wait();
                         } catch (InterruptedException e) {

                         }
                     }

                     System.out.println(value);
                     isEven = false;
                     notify();
                     value += 2;
                 }

             }
         }
    }

}
