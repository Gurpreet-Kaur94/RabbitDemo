package com.rabbitmq.rabbitmqdemo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    static List<Employee> employeeList
            = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
            new Employee("Tom Jones", 45, 7000.00),
            new Employee("Ethan Hardy", 65, 8000.00),
            new Employee("Nancy Smith", 22, 10000.00),
            new Employee("Deborah Sprightly", 29, 9000.00));
    // Java program to implement solution of producer
// consumer problem

    /*static int x = 10;

    static double temp = 98.6;


    static
    {
        System.out.println("temp = " + temp);
        System.out.println("x = " + x);
        temp = (temp - 32) * 5.0/9.0; // convert to Celsius
        System.out.println("temp = " + temp);
    }

    static
    {
        System.out.println("temp = " + temp);
        System.out.println("x = " + x);
        temp = (temp - 32) * 5.0/9.0; // convert to Celsius
        System.out.println("temp = " + temp);
    }

    static int y = x + 5;

    static
    {
        System.out.println("y = " + y);
    }*/



    public static int hashCode(char[] value) {
        int h = 0;
        int k = 0;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                System.out.println(h + "  " + (31 * h + val[i]));
                System.out.println(k + "  " + (31 ^ (value.length-i-1) * val[i]));
                k += 31 ^ (value.length-i-1) * val[i];
                h = 31 * h + val[i];
            }
            System.out.println(k + " kh " + h);
          //  hash = h;
        }
        return h;
    }

        public static void main(String[] args)
                throws  Exception {
            // Object of a class that has both produce()
            // and consume() methods

            String val = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<sterling:IssueAwardsRequest xsi:schemaLocation=\"urn:expedia:e3:partnerlty:sterling:messages:v1 com.expedia.e3.partnerlty.sterling.messages.v1.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:base=\"urn:expedia:e3:data:basetypes:defn:v4\" xmlns:sterling=\"urn:expedia:e3:partnerlty:sterling:messages:v1\" xmlns:types=\"urn:expedia:e3:partnerlty:sterling:types:v1\">\n" +
                    "<sterling:SterlingMessageInfo>\n" +
                    "<sterling:CallerApplicationName>String</sterling:CallerApplicationName>\n" +
                    "<sterling:MessageGUID>String</sterling:MessageGUID>\n" +
                    "</sterling:SterlingMessageInfo>\n" +
                    "<sterling:SiteIdentity>\n" +
                    "<base:SiteID>1</base:SiteID>\n" +
                    "</sterling:SiteIdentity>\n" +
                    "<sterling:User>\n" +
                    "<types:Tuid>\n" +
                    "<types:tpid>1</types:tpid>\n" +
                    "<types:tuid>6349954</types:tuid>\n" +
                    "</types:Tuid>\n" +
                    "<!--<types:ExpUserId>1000000</types:ExpUserId>-->\n" +
                    "</sterling:User>\n" +
                    "<types:transactionHistoryMode>without-history</types:transactionHistoryMode>\n" +
                    "<sterling:Component>\n" +
                    "<sterling:OrderNumber>9030012988590</sterling:OrderNumber>\n" +
                    "</sterling:Component>\n" +
                    "</sterling:IssueAwardsRequest>";
            Matcher matcher = Pattern.compile(".*<[\\w|:]*(?i)[o](?-i)rderNumber>(\\d+)</[\\w|:]*(?i)[o](?-i)rderNumber>.*", Pattern.DOTALL).matcher(val);
            String value =  (matcher.lookingAt()) ? matcher.group(1) : null;
            System.out.println(value);
/*Outer outer = new Outer();

        hashCode("abc".toCharArray());
            AtomicInteger count = new AtomicInteger();
            int c = count.getAndIncrement();
            System.out.println(c);*/
           /* try {
                outer.f();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("NPE");

            }
*/
           /* Parent p = new Child();

            p.method();
*/

          /* System.out.println(TestEnum.REGISTERED_ACCOUNT.equals(null));
           String name =  employeeList.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                    (Optional<Employee> emp) -> emp.isPresent() ? emp.get().getName() : "none"));
           System.out.println(name);

           //Optional<String> list = employeeList.stream().map(Employee::getName);


            String avg =  employeeList.stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(Employee::getSalary),
                    averageSalary -> new DecimalFormat("'$'0.00").format(averageSalary)));
            System.out.println(avg);

            List<String> countries = Arrays.asList("USA", "UK", "India");
            countries.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {Collections.reverse(l);
            return l.stream();
            }
            )).forEach(System.out::println);*/


          /* Book book = new Book("The Fellowship of the Ring", 1954, "0395489318");
            String requestClassName = book.getClass().toString();
            String requestName = requestClassName.substring(book.getClass().toString().lastIndexOf('.')+1);
            System.out.println( "TdAdaptorService." + requestName);
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
            bookList.add(new Book("The Two Towers", 1954, "0345339711"));
            bookList.add(new Book("The Return of the King", 1955, "0618129111"));

            Set<Book> bookSet = bookList.stream().collect(Collectors.toSet());

            Map<String, String> bookMap = bookList.stream().collect(Collectors.toMap(Book::getName, Book::getIsbn));

            Map<String, Integer> bookMapWithReleaseYear = bookList.stream().collect(Collectors.toMap(Book::getName, Book::getReleaseYear));

            bookMapWithReleaseYear.entrySet().stream().forEach( System.out::println);

            Map<Integer, String> bookMapWithReleaseYear1 = bookList.stream().
                    collect(Collectors.toMap(Book::getReleaseYear, Book::getName, (o, n) -> o, TreeMap::new));

            bookMapWithReleaseYear1.entrySet().stream().forEach(a -> System.out.println(a.getValue()));


            Map<String, Integer> sortByValue =  bookMapWithReleaseYear.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(a-> a.getKey(), a-> a.getValue(), (o, n) -> n, LinkedHashMap::new));


            sortByValue.entrySet().stream().forEach(System.out::println);*/
           /* final PC pc = new PC(10);
            Thread t1 = new Thread(() -> {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            Thread t2 = new Thread(() -> {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();*/
        }


    private static class PC {
            private LinkedList<Integer> list;
            private int capacity;


            PC(int capacity) {

                this.list = new  LinkedList<>();
                this.capacity = capacity;
            }

            public void produce() throws InterruptedException {
                int value = 0;
                while (true) {
                    synchronized (this) {
                        if (list.size() == capacity) {
                            wait();
                        }

                        value += 1;
                        System.out.println("producing " + value);
                        list.add(value);
                        notify();
                        Thread.sleep(1000);
                    }
                }
            }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    if (list.size() == 0) {
                        wait();
                    }

                    int last = list.removeFirst();
                    System.out.println("consuming " + last);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }


}
