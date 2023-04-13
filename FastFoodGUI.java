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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FastFoodGUI extends JFrame implements Serializable{
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2,b3;
    String oo;
    Customer gg;
     FastFoodGUI(String name1,Customer name2){
         gg=name2;
         oo=name1;
       setLayout(new BorderLayout());
        setSize(500,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
       l1=new JLabel("WELCOME TO Fast Food FOOD MENU");
        b1=new JButton("Check Dishes");
        t1=new JTextField(30);
        l2=new JLabel("Enter dish number: ");
        b2=new JButton("Return to Previous Menu");
        b3=new JButton("ADD");
        
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(1,1));
       p1.add(l1);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,1));
        p.add(b1);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3));
        p2.add(l2);
        p2.add(t1);
        p2.add(b3);
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(b2);
        p3.add(b1);
        
        
        
        
       
       
        add(p1,BorderLayout.NORTH);
         add(p,BorderLayout.SOUTH);
         add(p2,BorderLayout.CENTER);
         add(p3,BorderLayout.SOUTH);

         
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
        
        
       
     }

    private class MyActionListener implements ActionListener {

        public MyActionListener() {
        }
          public void actionPerformed(ActionEvent ae){
              if(ae.getActionCommand().equals("Return to Previous Menu")){
                  dispose();
                  Customer_Food_Order_CategoryGUI obj=new Customer_Food_Order_CategoryGUI(gg);
              }
              else if(ae.getActionCommand().equals(b1.getText())){
                  
                  JOptionPane.showMessageDialog(new JFrame(), Food.display1(oo));
              }
              
              else if(ae.getActionCommand().equals(b3.getText())){
                  if(t1.getText()==""){
                      JOptionPane.showMessageDialog(null, "Please input value");
                  }
                  else{
                      ArrayList<Food> o=Food.readFromFile();
                      int count=0;
                    for (int j = 0; j < o.size(); j++) {
                        if(o.get(j).getCategory().toUpperCase().equals(oo.toUpperCase())){
                        count++;
                        if(count==Integer.parseInt(t1.getText())){  
                        // o.add(o.get(j));
                         JOptionPane.showMessageDialog(null, "Dish Successfully Added");
                         Customer_Order obj=new Customer_Order(gg,o.get(j));
                         Customer_Order.writeToFile(obj);
                    }
                }
            }
                  }
              }
              
              
    }
    }
}