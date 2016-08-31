package com.javable.lec_16;

// DirClean.java: удаление всех файлов в указанном каталоге
/**
 * Программа должна принимать один или два параметра. Если параметр один, она должна работать так же, как и раньше.
 * Если задан второй параметр, то он задает расширение удаляемых файлов,
 * и тогда программа должна удалять только те файлы, которые имеют указанное расширение.
 */

import java.io.*;

public class DirClean {

    public static void main(String args[]) {
//--- 1. Проверим параметры вызова программы
        if ( args.length == 0 ) {
            System.out.println(" Формат вызова: java DirClean имя_каталога [расширение]");
            return;
        }
//--- 2. Создадим объект File для данного каталога и проверим, что
//       — он существует;
//       — что это действительно каталог.
        File dir = new File(args[0]);
        if ( !dir.isDirectory() ) {
            System.out.println("Каталог "+args[0]+" не существует или "+
                    "не является каталогом");
            return;
        }
//--- 3. Получим массив всех файлов в данном подкаталоге
        //в метод listFiles будет передаваться либо null , если нет второго параметра,
        //либо объект класса ExtFilter , если он есть
        //public File[] listFiles(FileFilter filter)
        // В отличие от одноименного метода, но без параметра, этот метод отбирает не все файлы данного каталога,
        // а только те, которые удовлетворяют определенному условию. Параметр filter предназначен для задания
        // этого условия. При этом тип параметра (FileFilter ) — это не класс, а интерфейс.
        // Обратимся к документации по интерфейсу FileFilter . Мы увидим, что данный интерфейс
        // имеет всего один метод public boolean accept(File pathname)
        // Этот метод должен возвращать true , если файл нам подходит, и false , если нет
        // Метод listFiles будет вызывать метод accept для каждого файла в каталоге, и те,
        // для которых accept вернет true , будут включены в результирующий список. Остальные будут проигнорированы
        // Для использования этих возможностей нам нужно построить класс, удовлетворяющий интерфейсу FileFilter ,
        // и определить в нем соответствующий метод accept


        File[] fList = dir.listFiles(args.length < 2 ? null : new ExtFilter(args[1]));
        int ftotal = fList.length;
        if ( ftotal == 0 ) { // нечего удалять
            System.out.println("Каталог "+args[0]+" уже пуст");
            return;
        }
//--- 4. Запрос к пользователю на подтверждение операции удалени
        System.out.println(" Подтвердите удаление "+ftotal+
                " файлов в каталоге "+args[0]+" Y/N");
        try {
            byte r[] = new byte[1];
            r[0] = (byte)System.in.read();
            char resp = (new String(r)).charAt(0);
            if ( resp == 'y' || resp == 'Y' ) {
                for ( int i = 0; i < ftotal; i++ )
                    fList[i].delete();
                System.out.println(" Удалено " + ftotal + " файлов");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Определим статический вложенный классExtFilter, удовлетворяющий интерфейсу FileFilter
    static class ExtFilter implements FileFilter {
        //Этому полю будет присваиваться значение второго параметра вызова программы в конструкторе класса ExtFilter
        String ext;

        ExtFilter(String ext) {
            this.ext = ext;
        }

        // Этот метод должен возвращать true , если файл нам подходит, и false , если нет
        // Метод listFiles будет вызывать метод accept для каждого файла в каталоге, и те,
        // для которых accept вернет true, будут включены в результирующий список
        public boolean accept(File pathname) {
            String extension = getExtension(pathname);
            return extension.equals(ext);
        }

        //для получения расширения файла
        private String getExtension(File pathname) {
            //при помощи вызова getPath мы получаем полное имя файла в виде строки.
            //Потом, используя методlastIndexOf класса String мы определяем позицию последней точки
            //в строке имени файла и вырезаем из строки подстроку от последней точки до конца строки
            String filename = pathname.getPath();
            int i = filename.lastIndexOf('.');
            if ( i>0 && i<filename.length()-1 ) {
                return filename.substring(i+1).toLowerCase();
            }
            return "";
        }

    }
}

