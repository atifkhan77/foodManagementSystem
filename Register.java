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
public class Register extends JFrame{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    
    Register(){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,2));
        
        l1 = new JLabel("Enter Name of Restaurant");
        t1 = new JTextField(30);
        l2 = new JLabel("Enter Owner Name of Restaurant");
        t2 = new JTextField(30);
        l3 = new JLabel("Enter Earning of Restaurant");
        t3 = new JTextField(30);
        l4 = new JLabel("Enter City of Restaurant");
        t4 = new JTextField(30);
                
        l5 = new JLabel("============= WELCOME TO REGISTER RESTAURANT MENU ====================");
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1));
        
        p2.add(l5);
        add(p2,BorderLayout.NORTH);
        
        p1.add(l1);p1.add(t1);p1.add(l2);p1.add(t2);p1.add(l3);p1.add(t3);p1.add(l4);p1.add(t4);
        add(p1,BorderLayout.CENTER);
        
        b1 = new JButton("Submit");
        b2 = new JButton("GO to Previous Menu");
        
        //another panel here for buttons
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        
        p3.add(b1);p3.add(b2);
        
        add(p3,BorderLayout.SOUTH);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
            
    }
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Submit")) {
                if (Double.parseDouble(t3.getText()) > 40000) {
                    Restaurant a = new Restaurant(t2.getText(), t1.getText(), t4.getText(), Double.parseDouble(t3.getText()));
                    Restaurant.writeToFile(a);
                    JOptionPane.showMessageDialog(new JFrame(),"Restaurant added successfully. ");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),"Your Restaurant does not have sufficient credit");
                }
            } else if (ae.getActionCommand().equals("GO to Previous Menu")) {
                Restaurant_Menu a = new Restaurant_Menu();
            }
        }
        
    }
}