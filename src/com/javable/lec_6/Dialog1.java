package com.javable.lec_6;

// Dialog1.java
// Первый пример визульного приложения на Java.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog1 {

    public static void main(String[] args) {
// фрагмент as is (1) обеспечивает Windows Look&Fill.
        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }
//JFrame — позволяет сформировать основное окно приложения.
// Все остальные визуальные компоненты помещаются внутрь этого окна.

        JFrame frm = new JFrame("Первое визуальное приложение");
        frm.setSize(300, 200);

        //Container — класс для визуальных классов-контейнеров, т.е. визуальных компонент,
        // которые могут внутри себя содержать другие визуальные компоненты.
        Container c = frm.getContentPane();  //получаем элемент, в который следует добавлять другие визуальные компоненты

        //JLabel — класс для создания меток.
        c.add(new JLabel("Hello, привет")); //создает и добавляет (метод add) метку на окно

// фрагмент as is (2) обеспечивает завершение всего приложения в случае, если закрылось главное окно приложения.
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frm.addWindowListener(wndCloser);
//

        frm.setVisible(true);  //выводит окно на экран и активизирует диалог с пользователем
    }
}


