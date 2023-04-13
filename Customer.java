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

public class Customer implements Serializable{
    private String Customer_Name;
    protected Address Customer_Address;
    private String email;
    private String phone_number;
    
    public Customer(){
        Customer_Name="Arshik";
        Customer_Address=new Address();
        email="DamFund@gmail.com"; 
        phone_number="213124214"; 
    }
    
    Customer(String cn, Address c, String e, String pn){
        Customer_Name=cn;
        Customer_Address=c;
        email=e; 
        phone_number=pn;        
    }
    
    public String getCustomer_Name(){
        return Customer_Name;
    }
     public Address getCity(){
        return Customer_Address;
    }
      public String getemail(){
        return email;
    }
       public String getphone_number(){
        return phone_number;
    }
       
     public void setCustomer_Name(String cn){
         Customer_Name=cn;
     }
     public void setCity(Address c){
         Customer_Address=c;
     }
     public void setemail(String e){
         email=e;
     }
     public void setphone_number(String pn){
         phone_number=pn;
     }
     public boolean Checking_Customer_Name() {

        ArrayList<Customer> o = new ArrayList<Customer>();
        o = readFromFile();
        for (Customer eeman : o) {
            if (eeman.getCustomer_Name().equals(this.Customer_Name)) {
                return true;
            }
        }
        return false;
    }
      public static void writeToFile(Customer s) {

        try {
            File f = new File("Customer.dat");

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
      public static ArrayList<Customer> readFromFile() {
        ArrayList<Customer> list = new ArrayList<Customer>();

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Customer.dat"));

            while (true) {
                Customer obj = (Customer) input.readObject();
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
    public static void updateCustomerName(String name, Customer obj){
        ArrayList<Customer> o=readFromFile();
        for(int i=0;i<o.size();i++){
            if(o.get(i).getCustomer_Name().equals(name)){
                o.get(i).setCustomer_Name(obj.Customer_Name);
                o.get(i).setCity(obj.getCity());
                o.get(i).setemail(obj.getemail());
                o.get(i).setphone_number(obj.getphone_number());
                
                
              
                break;
            }
        }
        try
        {
        File f = new File("Customer.dat");

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
    
    public static boolean Exist(String ss){
         ArrayList<Customer> o = readFromFile();
         for (Customer a : o) {
             if(a.getCustomer_Name().equals(ss)){
                 
                     return true;
                     
                
             }
         }
         return false;
                 
     }

    public static void display() {
        ArrayList<Customer> o = readFromFile();
        int count=0;
        for (Customer a : o) {
            System.out.println("============ CUSTOMER "+(count+1)+" ===================");
            System.out.println("Name: "+a.Customer_Name);
            System.out.println("House No: "+a.Customer_Address.getHome());
            System.out.println("Street No: "+a.Customer_Address.getStreet());
            System.out.println("City Name: "+a.Customer_Address.getCity());
            System.out.println("Email: "+a.email);
            System.out.println("Phone Number: "+a.phone_number);
            count++;
            
            
            
        }
    }
    public static void display(Customer a) {
        
            System.out.println("========================================================");
            System.out.println("Name: "+a.Customer_Name);
            System.out.println("House No: "+a.Customer_Address.getHome());
            System.out.println("Street No: "+a.Customer_Address.getStreet());
            System.out.println("City Name: "+a.Customer_Address.getCity());
            System.out.println("Email: "+a.email);
            System.out.println("Phone Number: "+a.phone_number);
            System.out.println("========================================================");
        
    }
    
    public static void display(String o) {
            ArrayList<Customer> a = readFromFile();
            for(int i=0;i<a.size();i++){
                if(a.get(i).getCustomer_Name().toUpperCase().equals(o.toUpperCase())){
                    System.out.println("========================================================");
                    System.out.println("Name: "+a.get(i).Customer_Name);
                    System.out.println("House No: "+a.get(i).Customer_Address.getHome());
                    System.out.println("Street No: "+a.get(i).Customer_Address.getStreet());
                    System.out.println("City Name: "+a.get(i).Customer_Address.getCity());
                    System.out.println("Email: "+a.get(i).email);
                    System.out.println("Phone Number: "+a.get(i).phone_number);
                    System.out.println("========================================================");
                    break;
                }
            }
            
        
    }
    public static void display2(String o) {
            ArrayList<Customer> a = readFromFile();
            String s="";
            for(int i=0;i<a.size();i++){
                if(a.get(i).getCustomer_Name().toUpperCase().equals(o.toUpperCase())){
                    s+="========================================================\n"+
                    "Name: "+a.get(i).Customer_Name+"\n"+
                    "House No: "+a.get(i).Customer_Address.getHome()+"\n"+
                    "Street No: "+a.get(i).Customer_Address.getStreet()+"\n"+
                    "City Name: "+a.get(i).Customer_Address.getCity()+"\n"+
                    "Email: "+a.get(i).email+"\n"+
                    "Phone Number: "+a.get(i).phone_number+"\n"+
                    "========================================================\n";
                    break;
                }
            }
            
        
    }

     
     
    
}
