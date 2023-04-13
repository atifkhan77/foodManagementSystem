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

/**
 *
 * @author Dell
 */
public class Display_Dishes extends JFrame{
    
    JButton b1,b2;
    JLabel l1;
    
    Display_Dishes(String s){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1));
        
        b1 = new JButton("Display the dishes of your restaurant");
        p1.add(b1);
        
        b2 = new JButton("GO TO PREVIOUS MENU");
        p1.add(b2);
        
        l1 = new JLabel(s);
        add(p1,BorderLayout.CENTER);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
    }
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Display the dishes of your restaurant")) {
                ArrayList<Food> o = Food.readFromFile();
                int count = 1;
                for (int i = 0; i < o.size(); i++) {
                    if (o.get(i).getRestaurant_Name().equals(l1.getText())) {
                        
                        JOptionPane.showMessageDialog(new JFrame(),"DISH " + count);
                        JOptionPane.showMessageDialog(new JFrame(),"Food Name is: " + o.get(i).getFood_Name() + " \n" +"Food Category is: " + o.get(i).getCategory() + " \n" + "Food Price is: " + o.get(i).getprice() + "\n" );
           
                        
                        count++;
                    }
                }
                
            } else if (ae.getActionCommand().equals("GO TO PREVIOUS MENU")) {
                Food_Menu a = new Food_Menu(l1.getText());
            }
        }

    }
}
