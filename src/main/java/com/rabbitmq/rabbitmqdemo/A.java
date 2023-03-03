package com.rabbitmq.rabbitmqdemo;

interface Test1 {

    interface Yes
        {
            void show();
        }
    }

    class Testing implements Test1.Yes
    {
        public void show()
        {
            System.out.println("show method of interface");
        }
    }

    class A
    {
        public static void main(String[] args)
        {
            Test1.Yes obj;
            Testing t = new Testing();
            obj=t;
            obj.show();
        }

}
