package com.javable.lec_10;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1. При копировании поля ввода нужно кроме собственно копирования организовать занесение строки из поля ввода
 * во внутренний список (список организовать, используя ArrayList или LinkedList).
 * 2. Добавить вниз экрана еще одну кнопку с надписью "Печатать". По нажатию на эту кнопку
 * весь сохраненный список должен быть выведен на печать (в поток System.out).
 */

public class Dialog10Home extends JFrame {

    JTextField fldi = new JTextField(20);
    JTextField fldo = new JTextField(20);
    ArrayList lst = new ArrayList();

    Dialog10Home() {
        super("Home Work (Lesson 9)");

        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 150);
        Container c = getContentPane();
        JLabel lblin = new JLabel("Поле    ввода ");
        JLabel lblout= new JLabel("Поле вывода ");
        JButton btn = new JButton("Скопировать");
        JButton btnprint = new JButton("Печать");
        JPanel pnlout = new JPanel();
        JPanel pnlin  = new JPanel();
        //Для размещения визуальных компонент здесь использованы 3 панели — pnlin, pnlout и pnlBtn
        pnlin.add(lblin);
        pnlin.add(fldi);
        c.add(pnlin, BorderLayout.NORTH);
        pnlout.add(lblout);
        pnlout.add(fldo);
        c.add(pnlout, BorderLayout.CENTER);
        JPanel pnlBtn = new JPanel();
        //JPanel pnlBtnPrn = new JPanel();
        pnlBtn.add(btn);
        pnlBtn.add(btnprint);
        //pnlBtnPrn.add(btnprint);
        //c.add(pnlBtnPrn, BorderLayout.WEST);
        c.add(pnlBtn, BorderLayout.SOUTH);

       // ArrayList lst = new ArrayList();

        //Вся функциональность данного приложения сосредоточена в двух "слушателях" (listener)
// Listener для поля ввода
        fldi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                fldo.setText(fldi.getText());
                fldi.setText("");
            }
        });
// Listener для кнопки копирования.
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                fldo.setText(fldi.getText());  // Копирование текста
                lst.add(new String(fldi.getText()));
                //System.out.println("добавлен элемент: "+ lst.add(new String(fldi.getText())));
                fldi.setText("");       // очистка поля ввода
                fldi.requestFocus();
            }
        });


  //  public String toString() {
    //    return (String) fldi.getText();
   // }


        // Listener для кнопки печати.
        btnprint.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!lst.isEmpty()) {

                    String res = "";
                    Iterator iter = lst.iterator();
                    for (int i = 0; iter.hasNext(); i++) {
                        if (i % 1 == 0)
                            res += "\n";
                        res += iter.next().toString();

                    }

                    System.out.println("Внутренний список ArrayList: "+ res);
                } else{
                    System.out.println("Внутренний список ArrayList не содержит элементов.");
                }
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
        new Dialog10Home();
    }
}

