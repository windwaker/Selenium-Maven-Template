package com.lazerycode.selenium.javaexamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import com.lazerycode.selenium.tests.Person;

/**
 * Created by colmh on 17/05/2015.
 */
public class PredicateExample {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(new Person(17, "Charlie"),
                new Person(24, "Adam"),
                new Person(22, "Bob"));

        System.out.println("==== Over 21 Method ====");
        printCanVote(personList);

        System.out.println("==== Under 18 Method ====");
        printNoBeer(personList);

        Predicate<Person> canVote = (p) -> p.getAge() > 21;
        Predicate<Person> noBeer = (p) -> p.getAge() < 18;
        Predicate<Person> nameStartsWithA = (p) -> p.getName().toLowerCase()
                                                                .startsWith("a");
//
        System.out.println("\nCan vote: ");
        // no method needed for printCanVote
        printFilteredList(personList, canVote);
//
        System.out.println("\nCan't have a beer (in Ireland): ");
        // no method needed for printListOfDrinkers
        printFilteredList(personList, noBeer);
//
        // Use default methods, very powerful concept for webpage testing
        System.out.println("\nCan Vote and name starts with the letter A ");
        printFilteredList(personList, canVote.and(nameStartsWithA));
    }

    public static void printCanVote(List<Person> list){
        for (Person p : list){
            if(p.getAge() > 21){
                // act on the data
                System.out.println("\t" + p.toString());
            }
        }
    }

    public static void printNoBeer(List<Person> list){
        for (Person p : list){
            if(p.getAge() < 18){
                // act on the data
                System.out.println("\t" + p.toString());
            }
        }
    }
      // value parameterization
      // new paths to be tested trough code :-(
//    public static void printByAge(List<Person> list, int ageLimit, Boolean greater, String nameStartsWith){
//        for (Person e : list){
//
//            if(greater == true){
//
//            }
//            if(e.getAge() > limit){
//                System.out.println("\t" + e.toString());
//            }
//        }
//    }

    public static void printFilteredList(List<Person> list,
                                         Predicate<Person> condition){
        list.stream().filter(condition)
                .forEach(p -> System.out.println("\t" + p.toString()));
    }
}
