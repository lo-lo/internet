package com.javable.lec_8;

import java.io.PrintStream;

public class Book extends Issue {

    String authors;
    public  Book(String name, String authors){
        super(name);
        this.authors = authors;
    }

    public void print(PrintStream out){
        out.print("  Авторы: ");
        out.println(authors);
        super.print(out);  //явный вызов метода базового класса
    }
}
