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

/**
 *
 * @author HERO
 */
public class CheckoutGUI extends JFrame implements Serializable{
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3,b4,b5,b6;
    JTextField t1;
    int oo;
    Customer name2;
    String name="";
    String bill="";
    double totalbill=0;
     CheckoutGUI(String naem){
        name=naem;
        setLayout(new BorderLayout());
        setSize(500,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        ArrayList<Customer_Order> o = Customer_Order.readFromFile();
          int count=0;
          double total=0;
          String ss="";
         ss+="========================= BILL ========================\n";
          ss+="Name: "+name+"\n";
          for (int i = 0; i < o.size(); i++) {
              System.out.println(o.get(i).getCustomer_Name().getCustomer_Name());
            if(o.get(i).getCustomer_Name().getCustomer_Name().toUpperCase().equals(name.toUpperCase())){
                ss+="======= DISH "+(count+1)+" ========="+
                "Dish: "+o.get(i).getOrder().getFood_Name()+"\n"+
                "Price: "+o.get(i).getOrder().getprice()+"\n";
                total+=o.get(i).getOrder().getprice();
                count++;
                System.out.println(total);
            }
        }
          System.out.println(name);
        bill=ss;
        totalbill=total;
       l1=new JLabel("WELCOME TO CATEOGRY MENU");
        b1=new JButton("Return to Previous Menu");
       
        b4=new JButton("Check Bill");
       l2=new JLabel("Your Subtotal is: "+total);
        l3=new JLabel("Apply Voucher: ");
        t1=new JTextField(30);
        b2=new JButton("Add Voucher");
        
      l4=new JLabel("Your Initial Total is: "+ total);
      l5=new JLabel("Initial Total With GST: "+(total+(total*0.2)));
       
       
        
        b3=new JButton("Go to Payment Menu");
       
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(1,1));
       p1.add(l1);
       
       

        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(l3);
        p2.add(t1);
        p2.add(b2);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1));
        p3.add(l4);
        p3.add(l5);
        p3.add(b3);
        p3.add(b4);
        p3.add(b1);

         add(p1, BorderLayout.NORTH);
         add(p2, BorderLayout.CENTER);
         add(p3, BorderLayout.SOUTH);


        
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        
       
        
        
       
     }

    private class MyActionListener implements ActionListener {

        public MyActionListener() {
        }
        @Override
          public void actionPerformed(ActionEvent ae){
              if(ae.getActionCommand().equals("Return to Previous Menu")){
                  dispose();
                  Customer_Food_Order_CategoryGUI obj=new Customer_Food_Order_CategoryGUI(name2);
              }
              
              else if(ae.getActionCommand().equals(b2.getText())){
                  // print dishes
                  if(t1.getText().toUpperCase().equals("atif".toUpperCase()) || t1.getText().toUpperCase().equals("tanzeel".toUpperCase())){
                  System.out.println("You have been given disocunt 10%");
                  totalbill=totalbill-totalbill*0.1;
                  JOptionPane.showMessageDialog(new JFrame(), "You have been given discount");
                  JOptionPane.showMessageDialog(new JFrame(),"Your total after applying voucher is: " + totalbill);
                  JOptionPane.showMessageDialog(new JFrame(),"Your total after applying voucher and GST is: "+(totalbill+(totalbill*0.2)));
              }
              else{
                  JOptionPane.showMessageDialog(new JFrame(),"Invalid Voucher");
              }
              }
              else if(ae.getActionCommand().equals(b3.getText())){
                  // print dishes
                  dispose();
                  CheckoutTotalGUI obj=new CheckoutTotalGUI(name);
              }
             else if(ae.getActionCommand().equals(b4.getText())){
                  // print dishes
                  dispose();
                  JOptionPane.showMessageDialog(new JFrame(),bill);
              }
              
              
    }
    }
}