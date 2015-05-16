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

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee(25, "Charlie"), new Employee(24, "Adam"), new Employee(25, "Bob"));

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

        System.out.println("=== Sorted by Lambda ===");
        Collections.sort(employeeList, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));

        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }
    }
}


