package com.rabbitmq.rabbitmqdemo;

public class GFG {
    static int getOccurence(int n, int d)
    {
        int count = 0;
        if(n < d ) {
            return 0;

        }

        int num = d;
        while(num <= n) {
        if(num % 10 == d) {
            System.out.println("is d" + num + " " + ((num / 10 )% 100));
            count += 1;
        }
        if(num % 10 == 0) {
            if(num + 10  < n) {
                count += 11;
                num += 10 + d;
            } else {
                if(n % 10 < d ) {
                    count += n % 10 + 1;
                    num = n + 1;
                } else {
                    count += n % 10 + 2;
                    num = n + 1;
                }
            }
        }
        else if(((num / 10 ) % 100) == d - 1) {
            num += (10-d);
        } else {
            num += 10;
        }
    }
      return count;

}


    // Driver code
    public static void main (String[] args)
    {
        int n = 46, d = 3;

        System.out.println(getOccurence(n, d) );
    }
}
