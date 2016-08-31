package com.javable.lec_10;

public class Outer3 {

    String name;

    static class Inner3 {
        //из статического класса можно обратиться к нестатическим полям и методам охватывающего класса,
        // но не напрямую, а через ссылку на объект охватывающего класса
        public void f(Outer3 obj){
            System.out.println(obj.name);  //Здесь без obj нельзя
        }
    }

    public static Inner3 createInner(){
        return new Inner3();
    }


    //примеры создания объекта класса Inner3 извне класса Outer3
    //Outer3.Inner3 obj1 = new Outer3.Inner3();   // явное порождение
    //Outer3.Inner3 obj2 = Outer3.createInner();   // порождение через метод createInner()
}
