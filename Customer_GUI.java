/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.management.system;

import static food.management.system.Customer.readFromFile;
import java.awt.BorderLayout;
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

/**
 *
 * @author Dell
 */
public class Customer_GUI extends JFrame{
    JLabel l1;
    JButton b1,b2,b3,b4;
    
    Customer_GUI(){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));

        l1 = new JLabel("====================== WELCOME TO CUSTOMER ADMINISTRATION MENU =======================");

        p1.add(l1);

        b1 = new JButton("See Details of All Customers");
        b2 = new JButton("See Details of Specific Customer");
        b3 = new JButton("See Reviews of Customers");
        b4 = new JButton("Go to Previous Menu");

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1));

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
    }
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("See Details of All Customers")) {
                dispose();
                
                ArrayList<Customer> o = Customer.readFromFile();
                
                int count = 0;
                String e="";
                for (Customer a : o) {
                    
                    e+=" CUSTOMER " + (count + 1)+"\n"+a.getCustomer_Name() + " " + a.Customer_Address.getHome() + " " + a.Customer_Address.getStreet() + " " + a.Customer_Address.getCity() + " " + a.getemail() + " " + a.getphone_number()+"\n" + "-------------------------------------" + "\n";
//                    JOptionPane.showMessageDialog(new JFrame(), " CUSTOMER " + (count + 1));
//                    JOptionPane.showMessageDialog(new JFrame(), a.getCustomer_Name() + " " + a.Customer_Address.getHome() + " " + a.Customer_Address.getStreet() + " " + a.Customer_Address.getCity() + " " + a.getemail() + " " + a.getphone_number());
                     
                    count++;

                }
                JOptionPane.showMessageDialog(new JFrame(),e);
                

            } else if (ae.getActionCommand().equals("See Details of Specific Customer")) {
                dispose();
                Specific_Cust a = new Specific_Cust();

            } else if (ae.getActionCommand().equals("See Reviews of Customers")) {
                dispose();
                ArrayList<Review> o = Review.readFromFile();
                for (int i = 0; i < o.size(); i++) {
                    JOptionPane.showMessageDialog(new JFrame(),"Customer name is: " + o.get(i).getCustomer_Name() + " \n" +"Customer Review: " + o.get(i).getCustomer_Review() + " \n" + "Customer Rating: " + o.get(i).getCustomer_Rating()+ " \n");

                }
            } else if (ae.getActionCommand().equals("Go to Previous Menu")) {
                dispose();
                Admin_GUI a = new Admin_GUI();
            }

        }
    }
}
