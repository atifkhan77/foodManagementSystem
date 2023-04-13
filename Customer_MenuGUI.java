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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Customer_MenuGUI extends JFrame{
    
    JButton b1,b2,b3,b4;
    Customer oo;
     Customer_MenuGUI(Customer obj1){
        oo=obj1;
        setLayout(new BorderLayout());
        setSize(500,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       
        b1=new JButton("Update your Information");
        b2=new JButton("Order Food");
        b3=new JButton("See your Details");
        b4=new JButton("Return to Previous Menu");
       
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,1));
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        

        add(p,BorderLayout.CENTER);
       
       
        
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        MyActionListener a1=new MyActionListener();
        b2.addActionListener(a1);
        MyActionListener a2=new MyActionListener();
        b3.addActionListener(a1);
        MyActionListener a3=new MyActionListener();
        b4.addActionListener(a1);
        
        
       
     }

    private class MyActionListener implements ActionListener {

        public MyActionListener() {
        }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals(b1.getText())) {
                dispose();
                Customer_Update_InformationGUI obj = new Customer_Update_InformationGUI(oo.getCustomer_Name(), oo);
            } else if (ae.getActionCommand().equals(b2.getText())) {
                dispose();
                Customer_Order_FoodGUI obj = new Customer_Order_FoodGUI(oo);
            } else if (ae.getActionCommand().equals(b3.getText())) {
                dispose();
                Customer.display2(oo.getCustomer_Name());
                
            } else if (ae.getActionCommand().equals(b4.getText())) {
                dispose();
                Customer_MainMenuGUI obj = new Customer_MainMenuGUI();
            }

        }
    }
}
