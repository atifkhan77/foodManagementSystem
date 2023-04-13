package food.management.system;

import static food.management.system.Food.readFromFile;
import static food.management.system.Restaurant.readFromFile;
import java.awt.BorderLayout;
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
public class Restaurant_GUI extends JFrame {

    JLabel l1;
    JButton b1, b2, b3, b4, b5;

    Restaurant_GUI() {
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));

        l1 = new JLabel("================ WELCOME TO ADMINISTRATION RESTAURANT MENU =======================");

        p1.add(l1);

        b1 = new JButton("Show all Restaurants");
        b2 = new JButton("Show all dishes");
        b3 = new JButton("Show dishes of specific Restaurant");
        b4 = new JButton("Delete a Restaurant");
        b5 = new JButton("GO TO PREVIOUS MENU");

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 1));

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);

    }

    public class MyActionListener implements ActionListener, Serializable {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Show all Restaurants")) {
                
                ArrayList<Restaurant> o = Restaurant.readFromFile();
                for (Restaurant a : o) {
                    JOptionPane.showMessageDialog(new JFrame(), "Restaurant Name is: " + a.getRestaurant() + " \n" + "Restaurant owner name is: " + a.getOwner_name() + " \n" + "Restaurant city is: " + a.getRestaurant_City());
                }

            } else if (ae.getActionCommand().equals("Show all dishes")) {
                
                ArrayList<Food> o = Food.readFromFile();
                for (Food a : o) {
                    JOptionPane.showMessageDialog(new JFrame(), "Restaurant name is: " + a.getRestaurant_Name() + " \n" + "Food name is: " + a.getFood_Name() + " \n" + "Food Category is: " + a.getCategory() + " \n" + "Price is: " + a.getprice());

                }
            } else if (ae.getActionCommand().equals("Show dishes of specific Restaurant")) {
                dispose();
                ArrayList<Restaurant> o = Restaurant.readFromFile();
                for (Restaurant a : o) {
                    JOptionPane.showMessageDialog(new JFrame(), "Restaurant Names are: " + a.getRestaurant() + " \n");
                }
                Specific_Rest a = new Specific_Rest();

            } else if (ae.getActionCommand().equals("Delete a Restaurant")) {
                dispose();
                ArrayList<Restaurant> o = Restaurant.readFromFile();
                for (Restaurant a : o) {
                    JOptionPane.showMessageDialog(new JFrame(), "Restaurant Names are: " + a.getRestaurant());
                }
                Del_Restaurant a = new Del_Restaurant();
                JOptionPane.showMessageDialog(new JFrame(), "Restaurant Successfully Deleted.");

            } else if (ae.getActionCommand().equals("GO TO PREVIOUS MENU")) {
                dispose();
                Admin_GUI a = new Admin_GUI();
            }

        }
    }
}
