
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


public class Registered_Restaurant extends JFrame{
    JLabel l1; 
    JButton b1,b2,b3;
    JTextField t1;
    
    Registered_Restaurant(){
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        
        l1 = new JLabel("Enter the restaurant name: ");
        t1 = new JTextField(30);
        
        p1.add(l1);p1.add(t1);
        
        add(p1,BorderLayout.CENTER);
        
        b1 = new JButton("Submit");
        b2 = new JButton("Go to Previous Menu");
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        
        p2.add(b1);p2.add(b2);
        
        add(p2,BorderLayout.SOUTH);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        
        
    }
    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Submit")) {
                if (Restaurant.Checking_Restaurant_Name(t1.getText())) {
                    Registered_Restaurant2 a = new Registered_Restaurant2(t1.getText());

                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(),"No such Restaurant exists");
                }
            }
            else if (ae.getActionCommand().equals("Go to Previous Menu")) {
                    Restaurant_Menu a = new Restaurant_Menu();
                }

            }
        }
    }

