package com.lazerycode.selenium.javaexamples;

import com.lazerycode.selenium.tests.Employee;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

/**
 * Created by colmh on 17/05/2015.
 */
public class StreamExample {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee(17, "Charlie"),
                new Employee(24, "Adam"),
                new Employee(25, "Bob"));

//        for(int i=0; i > employeeList.size(); i++)
//        {
//            System.out.println(employeeList[i]);
//        }
//
//        for(Employee e: employeeList){
//            System.out.println(e);
//        }

        System.out.println("No Filtering:");
        employeeList.stream().forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Sorted A-Z:");
        employeeList.stream().sorted(comparing(Employee::getName)).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Sorted Z-A:");
        employeeList.stream().sorted(comparing((Employee e) -> e.getName()).reversed()).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Filtering:");
        employeeList.stream().filter((e) -> e.getAge() > 21).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );
    }
}
