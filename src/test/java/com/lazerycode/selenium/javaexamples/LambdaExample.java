package com.lazerycode.selenium.javaexamples;

import com.lazerycode.selenium.tests.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by colmh on 16/05/2015.
 */
public class LambdaExample {

    private static void printEmployee(Employee e)
    {
        System.out.println(e);
    }

    public static void main(String[] args) {

        List<String> listOfStrings = Arrays.asList(new String("aaa"),
                                            new String("bbb"),
                                            new String("ccc"));

        listOfStrings.forEach((String s) -> System.out.println(s));


        List<Employee> employeeList = Arrays.asList(new Employee(25, "Charlie"),
                                                    new Employee(24, "Adam"),
                                                    new Employee(25, "Bob"));

        System.out.println("I came from a for loop and a method");
        for(Employee e : employeeList)
        {
            printEmployee(e);
        }

        System.out.println("I came from a lambda");
        employeeList.forEach((Employee e) -> System.out.println(e));






        System.out.println("=== Before sorting ===");
        for(Employee e:employeeList){
            System.out.println(e.toString());
        }

        // Sort with Inner Class
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        System.out.println("=== Sorted by inner class ===");
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }

        // scramble list again
        employeeList = Arrays.asList(new Employee(25, "Charlie"),
                new Employee(24, "Adam"),
                new Employee(25, "Bob"));

        System.out.println("=== Sorted by Lambda ===");
        Collections.sort(employeeList, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));

        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }

    }
}