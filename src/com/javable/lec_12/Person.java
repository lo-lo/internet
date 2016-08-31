package com.javable.lec_12;

// Person.java
// Этот класс предназначен для хранения информации по одной персоне

import java.io.Serializable;

public class Person implements Serializable, Comparable {


    private String name;
    private String phone;

    Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    Person() {
        this(null, null);
    }

    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    //метод compareTo(...) для сравнения двух персон
    public int compareTo(Object another) {
        return name.compareTo(((Person)another).name);
    }

    public String toString() {

        //return this.name+" "+this.phone;

        return ("\nФамилия: "+name+"\nТелефоны: "+phone+"\n");
    }

}

