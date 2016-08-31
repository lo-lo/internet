package com.javable.lec_15;

// DirClean.java: удаление всех файлов в указанном каталоге
/**
 * программа принимает только один параметр — имя каталога и удаляет все файлы в этом каталоге
 * В данной программе используются следующие методы класса File: isDirectory, listFiles, delete .
 * Нужно разобраться в этой программе и написать ее вариант, который удаляет только те файлы,
 * которые доступны и на чтение и на запись fList[i].canRead() && fList[i].canWrite()
 */

import java.io.*;

public class DirClean {

    /*
    public static File addFileInDir(File dir, String fname){


        File newfile = new File(dir, fname);
        try
        {
            boolean created = newfile.createNewFile();
            if(created)
                System.out.println("Файл "+fname+" создан");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
       // newfile.setWritable(write);
       // newfile.setReadable(read);
        return newfile;

    }
*/
    public static void main(String args[]) {
//--- 1. Проверим параметры вызова программы
        if ( args.length == 0 ) {
            System.out.println(" Формат вызова: java DirClean имя_каталога");
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
        //При создании экземпляра класса File реальный файл с указанным именем может не существовать.
        // При этом он не создается при создании объекта File .


        /*
        File f1 =addFileInDir(dir,"file1");
        f1.setReadable(true);
        f1.setWritable(true);
        File f2 = addFileInDir(dir,"file2");
        f2.setReadable(false);
        f2.setWritable(true);
        File f3 = addFileInDir(dir,"file3");
        f3.setReadable(false);
        f3.setWritable(true);
        File f4 = addFileInDir(dir,"file4");
        f4.setReadable(false);
        f4.setWritable(true);
        File f5 = addFileInDir(dir,"file5");
        f5.setReadable(false);
        f5.setWritable(true);
        File f6 = addFileInDir(dir,"file6");
        f6.setReadable(true);
        f6.setWritable(false);
*/

        File file1 = new File(args[0],"file1.txt");
        try {
            boolean created = file1.createNewFile();
            if(created){
                System.out.println("Файд file1 создан");
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        };

        file1.setReadable(true);
        file1.setWritable(false);
        //System.out.println(args[0]+"\\file.txt");

        File file2 = new File(dir, "file2.txt");
        try
        {
            boolean created = file2.createNewFile();
            if(created)
                System.out.println("Файл file2 создан");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        file2.setExecutable(true);
        file2.setWritable(false);
        file2.setReadable(true);

        File file3 = new File(args[0]+"file3.txt");
        try
        {
            boolean created = file3.createNewFile();
            if(created)
                System.out.println("Файл file3 создан");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        file3.setReadable(true);
        file3.setWritable(true);


        File[] fList = dir.listFiles();
        int ftotal = fList.length;
        System.out.println("количество файлов в каталоге: "+ftotal);
        if ( ftotal == 0 ) { // нечего удалять
            System.out.println("Каталог "+args[0]+" уже пуст");
            return;
        }
//--- 4. Запрос к пользователю на подтверждение операции удаления
        //System.out.println(" Подтвердите удаление "+ftotal+
        //        " файлов в каталоге "+args[0]+" Y/N");
        System.out.println(" Подтвердите удаление файлов в каталоге "+args[0]+" Y/N");

        try {
            int countDel = 0;
            byte r[] = new byte[1];
            //Читает один байт из входного потока. Результат, как ни странно, int (занимает 4 байта).
            // Прочитанный байт заносится в младший байт результата.
            r[0] = (byte)System.in.read();
            char resp = (new String(r)).charAt(0);
            if ( resp == 'y' || resp == 'Y' ) {
                for (int i = 0; i < ftotal; i++) {
                    boolean canRead = fList[i].canRead();
                    boolean canWrite = fList[i].canWrite();
                    //if ((fList[i].canRead()) && (fList[i].canWrite()))
                    if (canRead && canWrite) {
                        fList[i].delete();
                        countDel += 1;
                    }

                }
                System.out.println(" Удалено " + countDel + " файлов");
            }
            System.out.println("количество файлов в каталоге после удаления: "+(ftotal-countDel));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

