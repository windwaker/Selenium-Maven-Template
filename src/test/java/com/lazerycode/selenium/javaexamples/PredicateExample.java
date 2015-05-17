package com.lazerycode.selenium.javaexamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import com.lazerycode.selenium.tests.Employee;

/**
 * Created by colmh on 17/05/2015.
 */
public class PredicateExample {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee(17, "Charlie"),
                new Employee(24, "Adam"),
                new Employee(20, "Bob"));

        Predicate<Employee> canVote = (e) -> e.getAge() > 21;
        Predicate<Employee> noBeer = (e) -> e.getAge() < 18;

        System.out.println("\nCan vote: ");
        printFilteredList(employeeList, canVote);

        System.out.println("\nCan't have a beer (in Ireland): ");
        printFilteredList(employeeList, noBeer);

    }

    public static void printFilteredList(List<Employee> list, Predicate<Employee> condition){

        for(Employee e: list){
            if(condition.test(e))
                System.out.println("\t" + e.toString());
        }
    }
}
