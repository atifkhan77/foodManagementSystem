/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.management.system;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Restaurant implements Serializable, Interface_Restaurant{

    private String Owner_name;
    private String Restaurant;
    private String Restaurant_City;
    private double Restaurant_Earning;
    private Date1 joining;

    public Restaurant() {
        Owner_name = "SAD";
        Restaurant = "ASD AHMAD";
        Restaurant_City = "Rawalpindi";
        Restaurant_Earning = 41000;
        Date date = new Date(); // the date instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        joining = new Date1(month, day, year);
    }

    Restaurant(String on, String r, String rc, double re) {
        Owner_name = on;
        Restaurant = r;
        Restaurant_City = rc;
        Restaurant_Earning = re;

        Date date = new Date(); // the date instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        joining = new Date1(month, day, year);
    }

    public String getOwner_name() {
        return Owner_name;
    }

    public void setOwner_name(String n) {
        Owner_name = n;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String n) {
        Restaurant = n;
    }

    public String getRestaurant_City() {
        return Restaurant_City;
    }

    public void setRestaurant_City(String n) {
        Restaurant_City = n;
    }

    public double getRestaurant_Earning() {
        return Restaurant_Earning;
    }

    public void setRestaurant_Earning(double n) {
        Restaurant_Earning = n;
    }

    public Date1 getjoining() {
        return joining;
    }

    public void setjoining(Date1 n) {
        joining = n;
    }

    public boolean Checking_Restaurant_Name() {

        ArrayList<Restaurant> o = new ArrayList<Restaurant>();
        o = readFromFile();
        for (Restaurant a: o) {
            if (a.Restaurant.equals(this.Restaurant)) {
                return true;
            }
        }
        return false;
    }
    public static boolean Checking_Restaurant_Name(String n) {

        ArrayList<Restaurant> o = readFromFile();
        for (Restaurant a : o) {
            if (a.Restaurant.equals(n)) {
                return true;
            }
        }
        return false;
    }

    public static void writeToFile(Restaurant s) {

        try {
            File f = new File("Restaurant.dat");

            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        } catch (IOException e) {

        }

    }

    public static ArrayList<Restaurant> readFromFile() {
        ArrayList<Restaurant> list = new ArrayList<Restaurant>();

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Restaurant.dat"));

            while (true) {
                Restaurant obj = (Restaurant) input.readObject();
                list.add(obj);
            }

        } catch (ClassNotFoundException c) {

        } catch (ClassCastException c) {

        } catch (EOFException e) {

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        return list;
    }
    public static void updateRestaurantName(String name, String new_restaurant){
        ArrayList<Restaurant> o=readFromFile();
        for(int i=0;i<o.size();i++){
            if(o.get(i).getRestaurant().equals(name)){
                o.get(i).setRestaurant(new_restaurant);
              
                break;
            }
        }
        try
        {
        File f = new File("Restaurant.dat");

         ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
        
            for (int i = 0; i < o.size(); i++) {
                oos.writeObject(o.get(i));
            }
    
      
       oos.close();
        }
        catch (IOException e)
        {

        }
    }
    

    public static void display() {
        ArrayList<Restaurant> o = readFromFile();
        for (Restaurant a : o) {
            System.out.println(a.getOwner_name());
            System.out.println(a.getRestaurant());
            System.out.println(a.getRestaurant_City());
            System.out.println(a.getRestaurant_Earning());
            System.out.println(a.getjoining().getDay());
            System.out.println(a.getjoining().getMonth());
            System.out.println(a.getjoining().getYear());
        }
    }
    public static void display(Restaurant a) {
        
            System.out.println("========================================================");
            System.out.println("Owner Name: "+a.getOwner_name());
            System.out.println("Name of Restaurant: "+a.getRestaurant());
            System.out.println("City of Restaurant: "+a.getRestaurant_City());
            System.out.println("Earning of Restaurant: "+a.getRestaurant_Earning());
            System.out.println("Starting Day of Restaurant: "+a.getjoining().getDay());
            System.out.println("Starting Month of Restaurant: "+a.getjoining().getMonth());
            System.out.println("Starting Year of Restaurant: "+a.getjoining().getYear());
            System.out.println("========================================================");
        
    }

}
