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
import javax.swing.JPanel;

public class RestaurantDishesGUI extends JFrame {
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6;
    int oo;
    Customer name2;
     RestaurantDishesGUI(int name1,Customer name){
         oo=name1;
         name2=name;
       setLayout(new BorderLayout());
        setSize(500,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
       l1=new JLabel("WELCOME TO CATEOGRY MENU");
       l3=new JLabel("CATEGORIES");
        b1=new JButton("Desi");
        b2=new JButton("Fast Food");
        b3=new JButton("Chinese");
        b4=new JButton("Italian");
        b6=new JButton("Exit");
        b5=new JButton("Return to Previous Menu");
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(1,1));
       p1.add(l1);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(7,1));
        p.add(l3);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        
       
       
        add(p1,BorderLayout.NORTH);
         add(p,BorderLayout.CENTER);
       
       
        
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        MyActionListener a1=new MyActionListener();
        b2.addActionListener(a1);
        MyActionListener a2=new MyActionListener();
        b3.addActionListener(a1);
        MyActionListener a3=new MyActionListener();
        b4.addActionListener(a1);
        b5.addActionListener(a1);
        
        
       
     }

    private class MyActionListener implements ActionListener {

        public MyActionListener() {
        }
          public void actionPerformed(ActionEvent ae){
              if(ae.getActionCommand().equals("Return to Previous Menu")){
                  dispose();
                  Food_Order_RestaurantGUI obj=new Food_Order_RestaurantGUI(name2);
              }
              else if(ae.getActionCommand().equals(b1.getText())){
                  // print dishes
                  dispose();
                  DESIFOODGUI obj=new DESIFOODGUI(b1.getText(),name2);
              }
              else if(ae.getActionCommand().equals(b2.getText())){
                  // print dishes
                  dispose();
                  FastFoodGUI obj=new FastFoodGUI(b2.getText(),name2);
              }
              else if(ae.getActionCommand().equals(b3.getText())){
                  // print dishes
                  dispose();
                  ChineseGUI obj=new ChineseGUI(b3.getText(),name2);
              }
              else if(ae.getActionCommand().equals(b4.getText())){
                  // print dishes
                  dispose();
                  ItalianGUI obj=new ItalianGUI(b4.getText(),name2);
              }
               else if(ae.getActionCommand().equals(b6.getText())){
                  // print dishes
                  ArrayList<Food> order=Food.readFromFile();
                   for (int i = 0; i < order.size(); i++) {
            System.out.println("s");
            Customer_Order obj=new Customer_Order(name2,order.get(i));
            Customer_Order.writeToFile(obj);
            
        }
              }
              
              
    }
    }
}