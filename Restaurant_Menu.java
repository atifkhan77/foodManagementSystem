/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.management.system;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Restaurant_Menu extends JFrame implements Serializable {

    private Food food;
    JButton b1,b2,b3;
    JLabel l1;
    
    Restaurant_Menu(){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout());
        
        JLabel l1 = new JLabel("==========WELCOME TO RESTAURANT MENU==============");
        
        p1.add(l1);
        
        JButton b1 = new JButton("Is your Restaurant Already Registered?");
        JButton b2 = new JButton("Register Your Restaurant");
        JButton b3 = new JButton("Go TO Previous Menu");
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3,1));
        p2.add(b1);p2.add(b2);p2.add(b3);
        
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
    }
    
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("Is your Restaurant Already Registered?")) {
                dispose();
                Registered_Restaurant a = new Registered_Restaurant();
            }
            else if (ae.getActionCommand().equals("Register Your Restaurant")) {
                dispose();
                Register a = new Register(); 
            }
            else if (ae.getActionCommand().equals("Go TO Previous Menu")) {
                dispose();
                Main_Menu b = new Main_Menu();
                //StudentSearchByDept a = new StudentSearchByDept();
            }

        }
    }
}



    