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
public class Add_Food extends JFrame{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    
    Add_Food(String s){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        
        l1 = new JLabel("========WELCOME TO ADD FOOD MENU==========");
        
        p1.add(l1);
        
        l5 = new JLabel(s);
        l2 = new JLabel("Enter the name of food you want to add: ");
        t1 = new JTextField(30);
        
        l3 = new JLabel("Enter Category :" + "1. DESI 2. FAST_FOOD 3. ITALIAN 4. CHINESE");
        t2 = new JTextField(30);
        
        l4 = new JLabel("Enter the price of food: ");
        t3 = new JTextField(30);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3,2));
        
        p2.add(l2);p2.add(t1);p2.add(l3);p2.add(t2);p2.add(l4);p2.add(t3);
        
        b1 = new JButton("Submit");
        b2 = new JButton("GO TO PREVIOUS MENU");
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        
        p3.add(b1);p3.add(b2);
        
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        
    }
    
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Submit")) {
                Food obj = new Food(l5.getText(), t1.getText(), t2.getText(), Double.parseDouble(t3.getText()));
                Food.writeToFile(obj);
                System.out.println("updated");

            } else if (ae.getActionCommand().equals("GO TO PREVIOUS MENU")) {
                dispose();
                Food_Menu a = new Food_Menu(l5.getText());

            }
    }
}
}
