package com.javable.lec_9;

/**
 * определяем класс ShapeFactory с методами createCircle(...), createTriangle(...).
 * Для создания окружностей и треугольников мы внутри класса ShapeFactory описываем inner-классы Circle и Triangle.
 * Классы Triangle и Circle объявлены как private и потому недоступны.
 * методы createTriangle(...) и createCircle(...) порождают объекты Triangle и Circle,
 * но типом возвращаемого значения у них вляется Shape (при выполнении return выполняется upcasting).
 * Такое возможно благодаря тому, что и Triangle и Circle удовлетворяют интерфейсу Shape.
 * Таким образом, мы можем получить как треугольники, так и окружности, но дальше мы можем
 * работать с ними только как с абстрактными фигурами, используя методы, определенные в интерфейсе Shape.
 * классы Triangle и Circle должны содержать реализацию всех методов интерфейса Shape
 */

public class ShapeFactory {

    //описываем inner-класс Triangle
    private class Triangle implements Shape {
        Triangle(float a, float b, float c){

        }
    }

    //описываем inner-класс Circle
    private class Circle implements Shape {
        Circle(float r){

        }
    }

    public Shape createTriangle(float a, float b, float c){
        return new Triangle(a, b, c);
    }

    public Shape createCircle(float r){
        return new Circle(r);
    }

}
