package com.javable.lec_9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Пример визульного приложения на Java
 */

public class Dialog4 extends JFrame{
    //JTextField fld = new JTextField();
    JTextField fldin = new JTextField(20);
    JTextField fldout = new JTextField(20);
    JPanel pnlfldin = new JPanel();
    JPanel pnlfldout = new JPanel();
    JPanel pnlbtn = new JPanel();
    JButton btn = new JButton("Нажать кнопку");
    JLabel lbl = new JLabel(" ");

    Dialog4() {
        super("Слушатели (listeners) полей и кнопок");

        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 150);
        Container c = getContentPane();

        //pnlfld.add(fld);
        pnlfldin.add(fldin);
        pnlfldout.add(fldout);
        pnlbtn.add(btn);
        c.add(lbl, BorderLayout.NORTH);
        //c.add(fld, BorderLayout.CENTER);
        c.add(pnlfldin, BorderLayout.CENTER);
        //c.add(pnlfldout, BorderLayout.BEFORE_FIRST_LINE);
        c.add(pnlbtn, BorderLayout.SOUTH);

        //создание слушателей поля и кнопки. Оба слушателя выводят некоторую информацию в метку lbl,
        // для чего используется метод setText(...) класса JLabel
        fldin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Введен текст: "+fldin.getText()); //для выборки текста, введенного в поле fld,
                // использован метод getText() класса JTextField
            }
        });
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Нажата кнопка");
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog4();
    }
}
