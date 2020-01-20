package VehicleInheritance;

import VehicleHasA.CarPackages;
import java.util.ArrayList;

public class Car extends Vehicle  {
    
   private String drivingMode;
   private String fuelType;
   private int numOfSeats;
   private boolean sunRoof;
   private boolean spoiler;
   
   private ArrayList<CarPackages>  packageList  = new ArrayList<CarPackages>();

   public Car(String type, String brand, String model, double basePrice){
       super(type, brand, model, basePrice);
    }
   
   public Car(int Id, String type,String brand, String model, double basePrice, boolean warranty, 
           String color,String[] engine, String[] wheel, String gear,
                 String drivingMode, String fuelType, int numOfSeats,
                    boolean sunRoof, boolean spoiler, ArrayList<CarPackages> temp) {
       
        super(Id, type, brand, model, basePrice, warranty, color, engine, wheel, gear);
        this.drivingMode = drivingMode;
        this.fuelType = fuelType;
        this.numOfSeats = numOfSeats;
        this.sunRoof = sunRoof;
        this.spoiler = spoiler;
        this.packageList =temp;
    }
  
    @Override
  public double calculateNewPrice() {

        String engineType = engine[0];
        int horsePower=Integer.parseInt(engine[1]);
        double cap = Double.parseDouble(engine[2]);
        int torque = Integer.parseInt(engine[3]);
        double new_price;
        
        new_price = basePrice;
        new_price += horsePower*250;
        new_price += torque *50;
        new_price += cap *1000;
        
         if(engineType.equalsIgnoreCase("Class A") || engineType.equalsIgnoreCase("Class B") || engineType.equalsIgnoreCase("Class C") )
                 new_price += 50000;
         
             if(warranty)
                 new_price+=basePrice*15/100;
             if(gear.equalsIgnoreCase("Automatic"))
                 new_price+=2150;
            
             if(fuelType.equalsIgnoreCase("Diesel"))
                 new_price+=5000;   
             else if(fuelType.equalsIgnoreCase("Electric"))
                 new_price+=15000;
             
            if(sunRoof)
                new_price+=2500;
            if(spoiler)
                new_price+=1500;
             
             for(int i=0;i< packageList.size();i++)
                 new_price +=  packageList.get(i).getPrice();
    
        return new_price;
    }

   @Override
    public int calcMaxSpeed(){

        int horsePower = Integer.parseInt(engine[1]);
        double cap = Double.parseDouble(engine[2]);
        int torq = Integer.parseInt(engine[3]);
        int wheelInch = Integer.parseInt(wheel[1]);
        int maxSpeed;
                
        maxSpeed = (horsePower/2) + (wheelInch*2);
        maxSpeed += torq *0.05;
        maxSpeed += cap *10;
        
        if(drivingMode.equalsIgnoreCase("Sport"))
            maxSpeed += horsePower*0.5;
        else if(drivingMode.equalsIgnoreCase("Comfort"))
            maxSpeed += horsePower*0.3;
        else if(drivingMode.equalsIgnoreCase("Eco"))
            maxSpeed += horsePower*0.1;

            if(fuelType.equalsIgnoreCase("Gasoline"))
                 maxSpeed += horsePower *0.2;
              else
                 maxSpeed += horsePower *0.1;
             
             if(maxSpeed > 400)
                maxSpeed = 400;
             
        return maxSpeed;        
    }

    @Override
    public String toString() {
        
        String result ="\n#Car" + 
                super.toString() +
                "\nDriving Mode:" + drivingMode+
                "\nFuel Type: " + fuelType + 
                "\nNumber of Seats: " + numOfSeats + 
                "\nSunroof: " + sunRoof + 
                "\nSpoiler: " + spoiler;
   
            if(packageList.isEmpty())
                result += "\nCar Packages: None";
            else
                result +="\nCar Packages: " + packageList.toString();
                       
            result+= "\n|->Maximum Speed: " +calcMaxSpeed() +" km/h" +
                     "\n|->Total Price: "+ String.format("%,.0f", calculateNewPrice()) +"$";
                
           return result;
    }

}