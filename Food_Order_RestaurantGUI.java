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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Food_Order_RestaurantGUI extends JFrame{
    JLabel l1,l2,l3;
    JButton b1,b2,b3;
    JTextField t1;
    Customer oo;
     Food_Order_RestaurantGUI(Customer name1){
         oo=name1;
       setLayout(new BorderLayout());
        setSize(500,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
       l1=new JLabel("WELCOME TO Restaurant MENU");
       l2=new JLabel("Enter Restaurant Number");
        b1=new JButton("See Restaurants");
        b2=new JButton("Return to Previous Menu");
        b3=new JButton("Check");
        t1=new JTextField(30);
       JPanel p=new JPanel();
       p.setLayout(new GridLayout(1,1));
       p.add(l1);
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(1,1));
       p1.add(b1);
       
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3));
        p2.add(l2);
        p2.add(t1);
        p2.add(b3);
        
        
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1));
       p3.add(b2);
       
       
        
       
       
        add(p1,BorderLayout.NORTH);
         add(p,BorderLayout.CENTER);
         add(p2,BorderLayout.CENTER);
         add(p3,BorderLayout.SOUTH);
       
       
        
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        MyActionListener a1=new MyActionListener();
        b2.addActionListener(a1);
        MyActionListener a2=new MyActionListener();
        b3.addActionListener(a1);
        MyActionListener a3=new MyActionListener();
        
        
        
       
     }

    private class MyActionListener implements ActionListener {

        public MyActionListener() {
        }
        @Override
          public void actionPerformed(ActionEvent ae){
              if(ae.getActionCommand().equals("Return to Previous Menu")){
                  dispose();
                  Customer_Order_FoodGUI obj=new Customer_Order_FoodGUI(oo);
              }
              else if(ae.getActionCommand().equals(b1.getText())){
                  ArrayList<Restaurant> Restaurants=Restaurant.readFromFile();
                  String s="";
                  boolean ss=false;
                    for (int i = 0; i < Restaurants.size(); i++) {
                        s+=((i+1)+". "+Restaurants.get(i).getRestaurant());
                        ss=true;
        }
                    if(ss){
                         JOptionPane.showMessageDialog(new JFrame(), s);
                    }
                    else{
                         JOptionPane.showMessageDialog(new JFrame(), "No Restaurants to show");
                    }
                  
                  
              }
              
              else if(ae.getActionCommand().equals(b3.getText())){
                  // print dishes
                  dispose();
                  RestaurantDishesGUI obj=new RestaurantDishesGUI(Integer.parseInt(t1.getText()),oo);
              }
             
              
              
    }
    }
}