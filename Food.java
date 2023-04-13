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

public class Food implements Serializable{
    private String Restaurant_Name;
    private String Food_Name;
    private String Category;
    private double price;
    
    public Food(){
        
    }
    Food(String rn,String fn,String c,double p){
        Restaurant_Name=rn;
        Food_Name=fn;
        Category=c;
        price=p;
    }
    
    public String getRestaurant_Name() {
        return Restaurant_Name;
    }

    public void setRestaurant_Name(String n) {
        Restaurant_Name = n;
    }
     public String getFood_Name() {
        return Food_Name;
    }

    public void setFood_Name(String n) {
        Food_Name = n;
    }
     public String getCategory() {
        return Category;
    }

    public void setCategory(String n) {
        Category = n;
    }
     public double getprice() {
        return price;
    }

    public void setprice(double n) {
        price = n;
    }
    
    
     public static void writeToFile(Food s) {

        try {
            File f = new File("Food.dat");

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
     
     public static ArrayList<Food> readFromFile() {
        ArrayList<Food> list = new ArrayList<Food>();

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Food.dat"));

            while (true) {
                Food obj = (Food) input.readObject();
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
     public static boolean updateFood(String ss,Food s){
          
        ArrayList<Food> o=readFromFile();
        boolean zuzu=false;
        for(int i=0;i<o.size();i++){
            if(o.get(i).getFood_Name().equals(ss)){
                o.get(i).setFood_Name(s.getFood_Name());
                o.get(i).setCategory(s.getCategory());
                o.get(i).setprice(s.getprice());
                zuzu=true;
                break;
            }
        }
        try
        {
        File f = new File("Food.dat");

         ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
        
            for (int i = 0; i < o.size(); i++) {
                oos.writeObject(o.get(i));
            }
    
      
       oos.close();
        }
        catch (IOException e)
        {

        }
        return zuzu;
    }
     public static boolean Exist(String ss,String dish){
         ArrayList<Food> o = readFromFile();
         for (Food a : o) {
             if(a.getRestaurant_Name().equals(ss)){
                 if(a.getFood_Name().equals(dish)){
                     return true;
                     
                 }
             }
         }
         return false;
                 
     }
     //restaurant dishes
     public static void display(Food a){
        
            System.out.println("=============================================");
            System.out.println("Dish: "+a.getFood_Name());
            System.out.println("Category: "+a.getCategory());
            System.out.println("Price: "+a.getprice());
            System.out.println("a");
           
        
     }
     public static void display() {
        ArrayList<Food> o = readFromFile();
        for (Food a : o) {
            System.out.println("=============================================");
            System.out.println("Dish: "+a.getFood_Name());
            System.out.println("Category: "+a.getCategory());
            System.out.println("Price: "+a.getprice());
           
        }
    }
          public static void display1() {
        ArrayList<Food> o = readFromFile();
        for (Food a : o) {
            System.out.println("=============================================");
            System.out.println("Restaurant: "+a.getRestaurant_Name());
            System.out.println("Dish: "+a.getFood_Name());
            System.out.println("Category: "+a.getCategory());
            System.out.println("Price: "+a.getprice());
           
        }
    }
     public static String display1(String s){
         ArrayList<Food> o = readFromFile();
         boolean ss=false;
         String dish="";
         for (int i = 0; i < o.size(); i++) {
            if(o.get(i).getCategory().toUpperCase().equals(s.toUpperCase())){
                   dish += "========= DISH "+(i+1)+"=============\n"+
                    "Dish: "+o.get(i).getFood_Name()+
                    "\nPrice: "+o.get(i).getprice()+"\n";
                    ss=true;
                }
        }
         if(ss=false){
             return "No Dishes To print";
         }
         else{
             return dish;
         }
          }
    
}
