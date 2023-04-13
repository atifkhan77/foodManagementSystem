/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.management.system;

import static food.management.system.Customer.readFromFile;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Specific_Cust extends JFrame{
    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    
    Specific_Cust(){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        
        l1 = new JLabel("ENTER THE CUSTOMER NAME: ");
        t1 = new JTextField(30);
        
        p1.add(l1);p1.add(t1);
        
        b1 = new JButton("SUBMIT");
        b2 = new JButton("GO TO PREVIOUS MENU");
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(b1);p2.add(b2);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
    }
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("SUBMIT")) {
                
                ArrayList<Customer> a = readFromFile();
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).getCustomer_Name().toUpperCase().equals(t1.getText().toUpperCase())) {
                        JOptionPane.showMessageDialog(new JFrame(),"Customer Name is: " + a.get(i).getCustomer_Name() + " \n" + "Customer House No." + a.get(i).Customer_Address.getHome() + " \n" + "Customer Street No. " + a.get(i).Customer_Address.getStreet() + " \n" + "Customer City is: " + a.get(i).Customer_Address.getCity() + " \n" + "Customer mail is: " + a.get(i).getemail() + " \n" + "Customer phone number is: " + a.get(i).getphone_number() + "\n");
                        break;
                    }
                }
            } else if (ae.getActionCommand().equals("GO TO PREVIOUS MENU")) {
                dispose();
                Customer_GUI a = new Customer_GUI();
            }

        }
    }
}

