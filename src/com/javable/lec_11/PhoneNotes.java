package com.javable.lec_11;

// PhoneNotes.java: Записная книжка
/**
 * при вводе записи с фамилией, которую мы уже вводили, программа просто проигнорировала то, что мы вводили.
 * новый объект не заменяет существующий, а просто не добавляется в множество
 * счетчик записей внизу экрана приложения не изменился
 * Решение данной проблемы состоит в замене множества на ассоциативный массив (TreeSet на TreeMap)
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.*;
import java.io.UnsupportedEncodingException;

public class PhoneNotes extends JFrame {

    JTextField fldFio = new JTextField(25);
    JTextField fldPhone = new JTextField(25);
    JTextField fldCnt = new JTextField(4);
    TreeSet personTree = new TreeSet();  //поле для коллекции записей

    public PhoneNotes() {
        super("Записная книжка");

        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 250);
        Container c = getContentPane();  //рабочая часть
// Центральная панель
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        centerPanel.setBorder(BorderFactory.createEtchedBorder());
           JPanel aPanel = new JPanel();
        JLabel aLabel = new JLabel("Фамилия ");
           aPanel.add(aLabel);
           aPanel.add(fldFio);
           centerPanel.add(aPanel);
        //centerPanel.add(aLabel);
        //centerPanel.add(fldFio);
           aPanel = new JPanel();
        aLabel = new JLabel("Телефон ");
           aPanel.add(aLabel);
           aPanel.add(fldPhone);
           centerPanel.add(aPanel);
        //centerPanel.add(aLabel);
        //centerPanel.add(fldPhone);
           aPanel = new JPanel();
        JButton btn = new JButton("Печатать");
           aPanel.add(btn);
        //centerPanel.add(btn);
           centerPanel.add(aPanel);
        c.add(centerPanel, BorderLayout.CENTER);
// Нижняя панель
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(BorderFactory.createEtchedBorder());
        aLabel = new JLabel("Количество записей ");
        statusPanel.add(aLabel);
        fldCnt.setEnabled(false);
        statusPanel.add(fldCnt);
        c.add(statusPanel, BorderLayout.SOUTH);
// Listener'ы полей и кнопок
        fldPhone.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //создание объекта этого класса на основе информации из полей fldFio и fldPhone.
                // Кроме того, реализуем очистку этих полей после создания данного объекта
                Person person = new Person((String)fldFio.getText(), (String)fldPhone.getText());
                personTree.add(person); //занесение информации в коллекцию множеств класса TreeSet
                fldFio.setText("");       // очистка поля ввода
                fldPhone.setText("");

               // personTree.add(person);
                fldCnt.setText(""+personTree.size());
                fldFio.requestFocus();
//   ???
            }
        });
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                /**
                 * Iterator iter = set.iterator();
                 for ( int i = 0; iter.hasNext(); i++ ) {
                 Person cur = (Person)iter.next();
                 String str = cur.toString();
                 try {
                 byte[] b = str.getBytes("Cp866");
                 System.out.write(b);
                 } catch ( Exception ex ) {
                 ex.printStackTrace();
                 }
                 }

                 */
//   ???
                if(!personTree.isEmpty()) {

                    String res = "";
                    Iterator iter = personTree.iterator();
                    for (int i = 0; iter.hasNext(); i++) {
                        if (i % 1 == 0)
                            res += "\n";
                        res += iter.next().toString();

                    }

                    System.out.println("Записная книжка содержит записи: "+ res);
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
        new PhoneNotes();
    }
}
