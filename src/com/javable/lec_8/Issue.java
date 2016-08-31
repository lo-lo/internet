package com.javable.lec_8;

import java.io.PrintStream;

public class Issue {
    String name;
    public Issue(String name){
        this.name = name;
    }

    public void print(PrintStream out){
        out.print("Наименование: ");
        out.print(name);
    }

}
