package com.example.android_callactivity.model;

import java.io.Serializable;

/**
 * Model: Person
 * Description: Simple class model example;
 *
 * @see Person
 * @see Serializable
 */
public class Person implements Serializable {

    private String name;
    private String any;

    public Person(String name, String any) {
        this.name = name;
        this.any = any;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    @Override
    public String toString() {
        return "\n[Person]\n" +
                "\t\t-name='" + name + '\'' + '\n' +
                "\t\t-any='" + any + '\'' + '\n';
    }
}
