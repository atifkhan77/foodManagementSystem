/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.management.system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Admin_GUI extends JFrame {

    JLabel l1;
    JButton b1, b2, b3;

    Admin_GUI() {

        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));

        l1 = new JLabel("====================== WELCOME TO ADMINISTRATION MENU =======================");

        p1.add(l1);

        b1 = new JButton("Restaurant");
        b2 = new JButton("Customer");
        b3 = new JButton("Go to Previous Menu");

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 1));

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);

    }

    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Restaurant")) {
                dispose();
                Restaurant_GUI a = new Restaurant_GUI();

            } else if (ae.getActionCommand().equals("Customer")) {
                dispose();
                Customer_GUI a = new Customer_GUI();
            } else if (ae.getActionCommand().equals("Go to Previous Menu")) {
                dispose();
                Main_Menu a = new Main_Menu();
            }

        }
    }
}
