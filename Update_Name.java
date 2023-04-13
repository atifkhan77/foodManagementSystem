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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Update_Name extends JFrame{
    JTextField t1;
    JLabel l1,l2;
    JButton b1,b2;
    
    Update_Name(String s){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        
        l1 = new JLabel("Enter the updated name of Restaurant: ");
        t1 = new JTextField(39);
        
        p1.add(l1);
        p1.add(t1);
        
        l2 = new JLabel(s);
        
        b1 = new JButton("Submit");
        b2 = new JButton("Go to previous menu");
        
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
            if(ae.getActionCommand().equals("Submit")){
                Restaurant.updateRestaurantName(l2.getText(), t1.getText());
                JOptionPane.showMessageDialog(new JFrame(), "Restaurant Name Updated Successfully");
                
            }

            else if(ae.getActionCommand().equals("Go to previous menu")){
                Registered_Restaurant2 a = new Registered_Restaurant2(l2.getText()); 

        }
    }
}
}

