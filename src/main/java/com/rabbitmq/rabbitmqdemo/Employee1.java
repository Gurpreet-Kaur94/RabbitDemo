package com.rabbitmq.rabbitmqdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Employee1 {
    String name;
    public Employee1(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Employee1[] employees = new Employee1[6];
        int counter = 0;
        int i  =0;

        for(Employee1 emp : employees) {
//            System.out.println(emp);
           employees[i] = new Employee1("Linkedin" + (counter++));
//           System.out.println(emp.equals(employees[i]));
          i += 1;
//            System.out.println(emp.name);
        }

        Employee1 employee1 = employees[2];
        employee1 = new Employee1("Test");
        Employee1[] arrE = employees;
        System.out.println(employees.equals(arrE));
        System.out.println(arrE[2].equals(employee1));

        int[] arr = new int[10];
        for(int a : arr) {
           a += 1;
        }

        System.out.println(arr[2]);
        System.out.println(employees[2]);

        List<Employee1> employee1List = Arrays.asList(employees);
        Iterator<Employee1> iterable = employee1List.iterator();
        while(iterable.hasNext()) {
            Employee1 employee12 = iterable.next();
            employee1 = new Employee1("Linkedin" + (counter++));
            System.out.println(employee12);
        }

        System.out.println(employee1List.get(2));

    }
}
