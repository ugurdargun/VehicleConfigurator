package VehicleInheritance;
import VehicleInterface.MaxSpeed;
import java.util.Arrays;

public abstract class Vehicle implements MaxSpeed, Comparable<Vehicle>{
    
    //General
     protected int Id;
     protected String type;
     protected String brand;
     protected String model;
     protected double basePrice; 
     protected boolean warranty;
    //Exterior
     protected String color; 
    //Mechanic
     protected String engine[]; // engineType - capacity - horsePower - torque
     protected String wheel[]; // wheelType - wheelInch
     protected String gear;
     
    public Vehicle(String type, String brand, String model, double basePrice) {
        this.type = type;
        this.brand = brand;
        this.basePrice = basePrice;
        this.model = model;
    }

    public Vehicle( int Id, String type, String brand, String model, double basePrice, boolean warranty, 
            String color, String[] engine, String[] wheel, String gear) {
        
        this.Id = Id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.basePrice = basePrice;
        this.warranty = warranty;
        this.color = color;
        this.engine = engine;
        this.wheel = wheel;
        this.gear = gear;
    }

    public int getId() {
        return Id;
    }
    
    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }

    public double getBasePrice() {
        return basePrice;
    }
    
    @Override
    public int compareTo(Vehicle v2){
        return this.Id - v2.Id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.Id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  
                "\nID: " + Id + 
                "\nBrand: " + brand + 
                "\nModel: " + model +
                "\nBase Price: " + String.format("%,.0f", basePrice) + "$" +
                "\nWarranty: " + warranty + 
                "\nBody Color: " + color + 
                "\nEngine: " + Arrays.toString(engine) + 
                "\nWheel: "+ Arrays.toString(wheel) +
                "\nGear: " + gear;
               
    }

    public abstract double calculateNewPrice();
    
      @Override
        public abstract int calcMaxSpeed();
}