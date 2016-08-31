package com.javable.lec_10;

import java.util.*;
import java.io.*;


public class ArrayListTest {


    ArrayList lst = new ArrayList();

    //Random — класс из java.util. Расширяет возможности класса Math по генерации случайных чисел
    Random generator = new Random();

    //Метод addRandom() генерирует и заносит в коллекцию очередное случайное число
    void addRandom() {
        //добавить элемент в коллекцию можно методом add(...) класса ArrayList
        // и при этом мы нигде не указываем размер коллекции
        lst.add(new Integer(generator.nextInt()));  //Integer — так называемый wrapper-класс (класс-обертка)
        // для целых (int). Он использован потому, что в коллекцию нельзя занести данные элементарных типов,
        // а только объекты классов
    }


    public String toString() {
        //return lst.toString();

        //разбить строку на подстроки так, чтобы каждая из них содержала не более 6 чисел
        String res = "";
        //Метод iterator() из ArrayList возвращает объект, ссылку на который мы запоминаем в переменной iter.
        // Этот объект не интерфейса Iterator (нельзя построить объект интерфейса).
        // Это объект некоторого класса, определенного внутри ArrayList, удовлетворяющего интерфейсу Iterator.
        // Этот класс имеет свое имя, поля, возможно, какие-то private-методы. Но нас это не интересует.
        // Мы просто приводим его к типу Iterator и используем как итератор. Нам не требуется
        // выполнять приведение типа после извлечения объекта из коллекции.
        Iterator iter = lst.iterator();
        for(int i = 0; iter.hasNext(); i++) {
            if( i%6 == 0 )
                res += "\n";
            //Извлеченный из коллекции методом next() объект мы не приводим к типу Integer,
            //а сразу применяем метод toString(). Здесь используется то свойство, что все классы
            // имеют метод toString()
            res += " " + iter.next().toString();   // !!!
        }
        return res;
    }

    public static void main(String args[]) {
        ArrayListTest tst = new ArrayListTest();
        for(int i = 0; i < 100; i++ )
            tst.addRandom();
        System.out.println("Сто случайных чисел: "+tst.toString());
    }
}
