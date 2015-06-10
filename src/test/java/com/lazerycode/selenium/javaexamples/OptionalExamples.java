package com.lazerycode.selenium.javaexamples;

import java.util.Optional;

/**
 * Created by colmh on 07/06/2015.
 */
public class OptionalExamples {

    public static void main(String[] args) {

        Optional<String> fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );

        Optional<String> firstName = Optional.of( "Tom" ); //Optional.ofNullable(null);
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );


    }
}
