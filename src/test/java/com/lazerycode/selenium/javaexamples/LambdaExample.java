package com.lazerycode.selenium.javaexamples;

import com.lazerycode.selenium.tests.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by colmh on 16/05/2015.
 */
public class LambdaExample {

    // 1. name 2. args 3. body
    private static void printPerson(Person p)
    {
        System.out.println(p);
    }

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(new Person(25, "Charlie"),
                                                    new Person(24, "Adam"),
                                                    new Person(25, "Bob"));

        System.out.println("I came from a for loop and a method");
        // External iteration
        for(Person p : personList)
        {
            // Act on the data
            printPerson(p);
        }

        System.out.println("I came from a lambda");
        // Internal Iteration
        personList.forEach((Person p) -> System.out.println(p));
        // type inference
        personList.forEach(p -> System.out.println(p));
        // Method Reference, more syntactic sugar
        personList.forEach(System.out::println);


        System.out.println("=== Before sorting ===");
        for(Person p : personList){
            System.out.println(p.toString());
        }

        // Sort with Inner Class
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.println("=== Sorted by inner class ===");
        for (Person p : personList) {
            System.out.println(p.toString());
        }

        // scramble list again
        personList = Arrays.asList(new Person(25, "Charlie"),
                new Person(24, "Adam"),
                new Person(25, "Bob"));

        System.out.println("=== Sorted by Lambda ===");
        Collections.sort(personList, (Person p1, Person p2) -> p1.getName().compareTo(p2.getName()));

        for (Person p : personList) {
            System.out.println(p.toString());
        }

    }
}