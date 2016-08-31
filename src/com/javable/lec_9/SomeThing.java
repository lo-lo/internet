package com.javable.lec_9;

/**
 * класс-синглетон SomeThing
 * В любом месте программы вызов "SomeThing.getInstance()" обеспечит получение ссылки
 * на единственный объект данного класса. Это позволяет, во многих случаях, избежать передачи
 * и хранения перекрестных ссылок объектов друг на друга.
 */

public class SomeThing {

    private static SomeThing instance = null;

    //Конструктор описан как protected , что не позволяет создавать объекты данного класса операцией new вне класса.
    protected SomeThing(){

    }

    //Единственной возможностью получить объект данного класса является вызов метода getInstance .
    // В свою очередь, этот метод обеспечивает создание единственного экземпляра объекта SomeThing .
    public static final SomeThing getInstance(){
        if(instance == null) {
            instance = new SomeThing();
        }
        return instance;
    }
}
