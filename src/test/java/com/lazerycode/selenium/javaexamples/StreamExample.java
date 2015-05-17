package com.lazerycode.selenium.javaexamples;

import com.lazerycode.selenium.tests.Employee;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.Predicate;

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

        System.out.println("Raw Data:");
        employeeList.stream().forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Sorted A-Z:");
        employeeList.stream().sorted(comparing((Employee e) -> e.getName())).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Sorted A-Z: (Method Reference)");
        employeeList.stream().sorted(comparing(Employee::getName)).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Sorted Z-A:");
        employeeList.stream().sorted(comparing(Employee::getName).reversed()).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        System.out.println("Filtered: (inline)");
        // avoid inline predicates where possible for maintenance reasons
        employeeList.stream().filter((e) -> e.getAge() > 21).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );

        // no need to specify a type, JVM can infer it.
        Predicate<Employee> over21 = (e) -> e.getAge() > 21;

        System.out.println("Filtered: (external predicate)");
        employeeList.stream().filter(over21).forEach(
                (Employee e) -> System.out.println("\t" + e)
        );
    }
}
