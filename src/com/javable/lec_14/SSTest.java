package com.javable.lec_14;

import java.util.*;
import java.io.*;

/**
 * информация вводится построчно, каждая строка печатается.
 * После этого выполняется разбор строки при помощи класса StringTokenizer.
 * Строка разбивается на слова (слово - это подстрока, отделенная от другой подстроки пробелами).
 * Каждое слово анализируется на наличие цифры в начале слова и в этом случае преобразуется в число
 */

public class SSTest {
    public static void main(String args[]) {

        if( args.length == 0 ) {
            System.out.println("Нужен параметр вызова: имя файла");
            return;
        }
        String thisLine;

        try {
            //сам по себе этот класс использовать нельзя public BufferedReader(Reader in)
            // - только в комбинации с другим классом,
            // например с FileReader. Класс FileReader имеет два основных конструктора, позволяющих открыть файл

            BufferedReader fin = new BufferedReader(new FileReader(args[0]));
            //private static String fileName = "C:\\Nastya\\Java\\JavaVPrimerakh\\Internet\\src\\Files\\file.txt";

            while ((thisLine = fin.readLine()) != null) {
                System.out.println("==Введена строка:"+thisLine);
                StringTokenizer st = new StringTokenizer(thisLine);
                System.out.println("  Cтрока состоит из:");

                //есть ли еще слова в списке
                while (st.hasMoreTokens()) {
                    //очередное слово
                    String token = st.nextToken();
                    char c = token.charAt(0);
                    if( c < '0' || c > '9' )
                        System.out.println(token);
                    else {
                        double d = Double.parseDouble(token);
                        System.out.println(token+" - это число = "+d);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + args[0] + " не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
