package com.lazerycode.selenium.javaexamples;

import com.lazerycode.selenium.tests.Person;

import java.util.Arrays;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by colmh on 17/05/2015.
 */
public class StreamExample {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(new Person(17, "Charlie"),
                new Person(24, "Adam"),
                new Person(25, "Bob"));

//        for(int i=0; i > personList.size(); i++)
//        {
//            System.out.println(personList[i]);
//        }
//
//        for(Person e: personList){
//            System.out.println(e);
//        }

        System.out.println("Raw Data:");
        personList.stream().forEach(
                (Person p) -> System.out.println("\t" + p)
        );

        System.out.println("Sorted A-Z:");
        personList.stream().sorted(comparing((Person e) -> e.getName())).forEach(
                (Person p) -> System.out.println("\t" + p)
        );

        System.out.println("Sorted A-Z: (Method Reference)");
        personList.stream().sorted(comparing(Person::getName)).forEach(
                (Person p) -> System.out.println("\t" + p)
        );

        System.out.println("Sorted Z-A:");
        personList.stream().sorted(comparing(Person::getName).reversed()).forEach(
                (Person p) -> System.out.println("\t" + p)
        );

        System.out.println("Filtered: (inline)");
        // avoid inline predicates where possible for maintenance reasons
        personList.stream().filter((e) -> e.getAge() > 21).forEach(
                (Person p) -> System.out.println("\t" + p)
        );

        // no need to specify a type, JVM can infer it.
        Predicate<Person> over21 = (p) -> p.getAge() > 21;

        System.out.println("Filtered: (external predicate)");
        personList.stream().filter(over21).forEach(
                (Person p) -> System.out.println("\t" + p)
        );
    }
}
