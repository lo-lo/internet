package com.javable.lec_8;

public class RunTest {

    public static void main(String[] args) {
        //порождается каталог (массив печатных изданий), причем каждое из печатных изданий
        // каталога может быть как книгой, так и газетой или журналом.
        // выполняется приведение к базовому типу (upcasting)
        Issue[] catalog = new Issue[]{
                new Journal("Play game"),
                new Newspaper("Спид Инфо"),
                new Book("Война и мир", "Л.Толстой")};


//в цикле мы печатаем информацию из каталога. Причем, для книг кроме наименования печатается еще и список авторов.
// Для этого с использованием операции instanceof проверяется тип печатного издания, а при самой печати списка авторов
// элемент каталога преобразуется к типу Book. Если этого не сделать, транслятор выдаст ошибку,
// т.к. метод printAuthors(...) есть только в классе Book
       /*
        for (int i = 0; i < catalog.length; i++) {
            catalog[i].print(System.out);
            if (catalog[i] instanceof Book)
                ((Book) catalog[i]).printAuthors(System.out);
            System.out.println();

        }
*/

        //  В классах Issue и Book вместо двух методов printName(...) и printAuthors(...) теперь один метод print(..).
        // В классе Book метод print(...) переопределяет одноименный метод класса Issue.
        for (int i = 0; i < catalog.length; i++) {
            //Теперь при печати каталога мы можем не делать специальную проверку для Book.
            // Нужный метод print(...) класса Book будет вызван автоматически благодаря механизму позднего связывания.
            catalog[i].print(System.out);
        }

    }
}