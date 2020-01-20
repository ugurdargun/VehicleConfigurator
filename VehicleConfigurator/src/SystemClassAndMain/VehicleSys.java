package SystemClassAndMain;

import Comparator.*;
import VehicleInheritance.*;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class VehicleSys {
     
    private static Set<Vehicle> vehicleSet = new LinkedHashSet<Vehicle>();
    private static ArrayList<Vehicle> vehicleList= new ArrayList<Vehicle>();

    public static void readFromFile(){ 
       
        String result="";

        File vehicleTxt = new File("data/VehicleList.txt");
        Scanner sc=null;
        try{
            
            sc = new Scanner(vehicleTxt);
            
            while(sc.hasNextLine()){
                String [] temp= sc.nextLine().split("\\*"); // type * brand * model * basePrice
                
                if(temp[0].equalsIgnoreCase("Car")){
                    Car cc = new Car(temp[0], temp[1], temp[2], Double.parseDouble(temp[3])); 
                    vehicleList.add(cc);
                }
                else if(temp[0].equalsIgnoreCase("Truck")){
                    Truck tt = new Truck(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]));
                    vehicleList.add(tt);
                }
                else if(temp[0].equalsIgnoreCase("Bus")){
                    Bus bb = new Bus(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]));
                    vehicleList.add(bb);
                }
                    
            }
 
        }
        catch(FileNotFoundException ex){
             ex.printStackTrace();
        }
        sc.close();
  
    }
    
    public static Set<Vehicle> getVehicleSet() {
        return vehicleSet;
    }

    public static ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

   public static boolean checkVehicleID(int id){
  
        Iterator<Vehicle> i = vehicleSet.iterator();
        while (i.hasNext()) {
            Vehicle v = i.next();
            if (v.getId() == id) {
                return true;
            }
        }
       return false;
    }
    
    public static boolean addVehicle(int id, Car c, Truck t, Bus b){ 

      if(!checkVehicleID(id)) {
          if(c != null)
            vehicleSet.add(c);
          else if(t != null)
            vehicleSet.add(t);
          else if(b != null)
            vehicleSet.add(b);

          return true;
      }
      else 
          return false;

    }
    
    public static Vehicle searchVehicle(int id){
        
        Iterator<Vehicle> i = vehicleSet.iterator();
        while (i.hasNext()) {
            Vehicle v = i.next();
            if (v.getId() == id) {
                return v;
            }
        }
        
        return null;
    }
    
    public static Vehicle removeVehicle(int id){
        
       Iterator<Vehicle> i = vehicleSet.iterator();
        while (i.hasNext()) {
            Vehicle v = i.next();
            if(v.getId() == id) {
                vehicleSet.remove(v);
                return v;
            }
        }
        
        return null;
    }
    
    public static String displayAllVehicles(){
       
        String result="";
        
       for (Vehicle ve : vehicleSet){
           result += ve.toString() + "\n\n***********************************\n";
       } 
 
       return result;
    }
    
     public static String displayAllVehiclesByPrice() {
        
       String result = ""; 
        
       VehiclePriceComparator vbc = new  VehiclePriceComparator();
       ArrayList<Vehicle> sortedList = new ArrayList<>();
       sortedList.addAll(vehicleSet);

       Collections.sort(sortedList, vbc); 
       
        for (Vehicle v : sortedList) {
            result += v.toString() + "\n\n***********************************\n";
        }
        
        return result;
    }
    
    public static String displayTheVehicle(String type){
        String result="";
        
       for (Vehicle ve : vehicleSet){
           
           if(type.equalsIgnoreCase("Car")){
                if(ve instanceof Car)
                 result += ve.toString() + "\n\n***********************************\n";
           }
           else if(type.equalsIgnoreCase("Truck")){
                if(ve instanceof Truck)
                 result += ve.toString() + "\n\n***********************************\n";
           }
           else if(type.equalsIgnoreCase("Bus")){
                if(ve instanceof Bus)
                 result += ve.toString() + "\n\n***********************************\n";
           }
         
       } 
 
       return result ;
    }

      public static String displayTheVehicleByPrice(String type){
        
        String result="";
          
       VehiclePriceComparator vbc = new  VehiclePriceComparator();
       ArrayList<Vehicle> sortedList = new ArrayList<>();
       sortedList.addAll(vehicleSet);

       Collections.sort(sortedList, vbc); 
        
       for (Vehicle ve : sortedList){
           
           if(type.equalsIgnoreCase("Car")){
                if(ve instanceof Car)
                 result += ve.toString() + "\n\n***********************************\n";
           }
           else if(type.equalsIgnoreCase("Truck")){
                if(ve instanceof Truck)
                 result += ve.toString() + "\n\n***********************************\n";
           }
           else if(type.equalsIgnoreCase("Bus")){
                if(ve instanceof Bus)
                 result += ve.toString() + "\n\n***********************************\n";
           }
           
       } 
 
       return result;
    }
}