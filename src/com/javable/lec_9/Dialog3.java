package com.javable.lec_9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Пример визульного приложения с текстовой областью на Java
 */

public class Dialog3 extends JFrame {
    JTextArea txt;

    Dialog3() {
        super("Визульное приложение с текстовой областью");

        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 200);
        Container c = getContentPane();
        c.add(new JLabel("Hello, привет"), BorderLayout.NORTH);
        txt = new JTextArea(5, 30);
        JScrollPane pane = new JScrollPane(txt);
        c.add(pane, BorderLayout.CENTER);


// порождается анонимный класс на базе класса WindowAdapter и создается объект ( wndCloser ) этого класса.
// Потом этот объект передается в метод addWindowListener(...) в качестве параметра
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    public void test() {
        txt.append("Первая строка\n");
        txt.append("Вторая строка\n");
    }

    public static void main(String[] args) {
        Dialog3 d = new Dialog3();
        d.test();
    }
}
