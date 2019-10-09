/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool_cleaning_service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario.Vega003
 */

class Customer{
    private String name, address;
    private int gallonsEstimate;
    private double ph_Pool;

    public Customer(String name, String address, int gallonsEstimate, double ph_Pool) {
        this.name = name;
        this.address = address;
        this.gallonsEstimate = gallonsEstimate;
        this.ph_Pool = ph_Pool;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", gallonsEstimate=" + gallonsEstimate + ", ph_Pool=" + ph_Pool + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPh_Pool(double ph_Pool) {
        this.ph_Pool = ph_Pool;
    }
    
    // read in the data from the keyboard but today it will be from a file

    public double getPh_Pool() {
        return ph_Pool;
    }
    
}

public class Pool_Cleaning_Service {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Customer> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("PoolCustomers.csv");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {                
                String line = sc.nextLine();
                String[] elements = line.split(",");
                arrayList.add(new Customer(elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pool_Cleaning_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Customer c : arrayList){
            if(c.getPh_Pool() > 7){
                System.out.println(c);
            }
        }
    }
    
}
