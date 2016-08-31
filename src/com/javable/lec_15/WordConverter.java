package com.javable.lec_15;

import java.util.*;
import java.io.*;

/**
 * Программа WordConverter.java предназначена для проведения поиска и замены слов в тексте.
 * Она принимает три параметра вызова: имя файла, строку для поиска и строку для замены.
 * В результате ее работы создается файл с именем res.txt , содержащий результаты замены и
 * печатается краткий протокол.
 */
public class WordConverter {

    public static void main(String args[]) {

        if (args.length < 2) {
            System.out.println("Формат вызова:");
            System.out.println("java WordConverter <имя файла> <строка для поиска> <строка для замены>");
            return;
        }
        String thisLine;
        BufferedReader fin = null;
        PrintWriter fout = null;

        try {
            fin = new BufferedReader(new FileReader(args[0]));
            fout = new PrintWriter(new BufferedWriter(new FileWriter("res.txt")));
            int lineCnt = 0, replCnt = 0;
            for (; (thisLine = fin.readLine()) != null; lineCnt++) {
                StringTokenizer st = new StringTokenizer(thisLine, " \t,;+-[]()./*&=~!|:?<>{}", true);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (token.equals(args[1])) {
                        fout.print(args[2]);
                        replCnt++;
                    } else
                        fout.print(token);
                }
                fout.println();
            }
            System.out.println();
            System.out.println("=== Результаты: ===");
            System.out.println("    Строк в файле    : " + lineCnt);
            System.out.println("    Произведено замен: " + replCnt);
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + args[0] + " не найден");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();         // !!! Закрыть файл
                } catch (IOException ex) {
                    System.out.println("Ошибка закрытия файла " + args[0]);
                    System.out.println("Error: " + ex);
                }
                fin = null;
            }
            if (fout != null) {
                fout.close();         // !!! Закрыть файл
                fout = null;
            }
        }

    }
}

/**
 Изменим программу WordConverter.java так, чтобы она в результате своей работы порождала бы не новый файл res.txt ,
 а модифицировала существующий. При этом исходный файл она должна сохранить с расширением bak .
 Изучим проблему.
 Во-первых, мы не можем сразу писать в тот же файл, из которого мы читаем. Поэтому для вывода нам понадобится
 какой-то файл. После окончания обработки исходного файла мы должны его переименовать в файл с расширением bak
 (нужно не забыть закрыть его перед переименованием). Когда мы переименуем исходный файл,
 мы можем переименовать выходной файл.
 Таким образом, нам потребуется.
 a. Возможность создания временного файла.
 b. Возможность переименования файлов.
 Все это есть в классе File . Во-первых, есть два метода createTempFile . Лучше использовать второй из них.
 public static File createTempFile(String prefix,
 String suffix, File directory)
 throws IOException
 Иначе могут возникнуть проблемы с переименованием файла, если временный файл будет создан физически
 не на том же диске, что и исходный. Но в этом случае нам нужно иметь параметр directory — каталог,
 в котором находится исходный файл. Для получения каталога можно использовать метод
 public File getParentFile()
 Возможность переименования файлов тоже имеется в классе File — это метод
 public boolean renameTo(File dest)
 Теперь осталось только все это собрать воедино и получить работающую программу.
*/