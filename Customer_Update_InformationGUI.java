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

public class Customer_Update_InformationGUI extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
     JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Customer g;
     Customer_Update_InformationGUI(String prename,Customer name){
       setLayout(new BorderLayout());
        setSize(500,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       t1=new JTextField(30);
       t2=new JTextField(30);
       t3=new JTextField(30);
       t4=new JTextField(30);
       t5=new JTextField(30);
       t6=new JTextField(30);
       l8=new JLabel(prename);
        b1=new JButton("<= Go to Previous Menu");
        b2=new JButton("Update");
        l1=new JLabel("WELCOME TO UPDATE CUSTOMER INfROMATION");
        l2=new JLabel("Enter Your Name");
        l3=new JLabel("Enter Your House No");
        l4=new JLabel("Enter Your Street No");
        l5=new JLabel("Enter Your City");
        l6=new JLabel("Enter Your Email");
        l7=new JLabel("Enter Your Phone Number");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,1));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6,2));
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1));
        p.add(b1);
        
        g= name;
       
         p.add(l1);
         p1.add(l2);
         p1.add(t1);
         p1.add(l3);
         p1.add(t2);
         p1.add(l4);
         p1.add(t3);
         p1.add(l5);
         p1.add(t4);
         p1.add(l6);
         p1.add(t5);
         p1.add(l7);
         p1.add(t6);
        
        p2.add(b2);
        
         add(p,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
       
        
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        MyActionListener a1=new MyActionListener();
        b2.addActionListener(a1);
        MyActionListener a2=new MyActionListener();
        
       
     }

    private class MyActionListener implements ActionListener {

        public MyActionListener() {
        }
          public void actionPerformed(ActionEvent ae){
              if(ae.getActionCommand().equals("<= Go to Previous Menu")){
                  dispose();
                  Customer obj ;
                  Customer_MenuGUI a = new Customer_MenuGUI(g);
              }
              else if(ae.getActionCommand().equals("Update")){
                  if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals("")  ){
                      JOptionPane.showMessageDialog(null, "Please input all text fields..!!");
                  }
                  else{
                      
                      Customer obj=new Customer(t1.getText(),new Address(Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()),t4.getText()),t5.getText(),t6.getText());
                      Customer.updateCustomerName(l8.getText(), obj);
                      JOptionPane.showMessageDialog(null, "Customer Updated Successfully\n Returning to Customer Menu");
                      Customer_MenuGUI obj1=new Customer_MenuGUI(obj);
                      dispose();
                  }
                  
              }
              
    }
    }
}