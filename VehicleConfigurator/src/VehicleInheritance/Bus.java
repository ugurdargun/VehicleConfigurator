package VehicleInheritance;

public class Bus extends Vehicle  {
    
    private int numOfFloors;
    private boolean stretched; 
    private int numOfSeats;
    private double trunkVolume;
    
    public Bus(String type, String brand, String model, double basePrice){
       super(type, brand, model, basePrice);
    }

    public Bus(int Id, String type, String brand, String model, double basePrice, boolean warranty,String color,
           String[] engine, String[] wheel, String gear,
                int numOfFloors, boolean stretched, double trunkVolume, int numOfSeats) {
        
        super(Id, type, brand, model, basePrice, warranty,color, engine, wheel, gear);
        this.numOfFloors = numOfFloors;
        this.stretched = stretched;
        this.numOfSeats = numOfSeats;
        this.trunkVolume = trunkVolume;
    }

   @Override
    public double calculateNewPrice() {
       
        String engineType = engine[0];
        int horsePower=Integer.parseInt(engine[1]);
        double cap = Double.parseDouble(engine[2]);
        int torque = Integer.parseInt(engine[3]);
        double new_price;
          
        new_price = basePrice;
        new_price += horsePower*140;
        new_price += torque *30;
        new_price += cap *1200;
         
             if(engineType.equalsIgnoreCase("Class A") || engineType.equalsIgnoreCase("Class B") )
                 new_price += 30000;
             
             if(warranty)
                 new_price+=basePrice*0.15;
             if(gear.equalsIgnoreCase("Automatic"))
                 new_price+=2150;
      
        new_price += numOfSeats * 125; 
        new_price += numOfFloors *25000; 
     
             if(stretched)
                 new_price+= 23000;
     
        return new_price;
    }
    
    @Override
    public int calcMaxSpeed(){
       
        int horsePower=Integer.parseInt(engine[1]);
        double cap = Double.parseDouble(engine[2]);
        int torq = Integer.parseInt(engine[3]);
        int wheelInc = Integer.parseInt(wheel[1]);
        
        int maxSpeed;
              
        maxSpeed=horsePower/4 + (wheelInc*2);
        maxSpeed += torq *0.03;
        maxSpeed += cap *7;
        
        maxSpeed -= numOfFloors * 10;
        maxSpeed -= numOfSeats *0.2;
        maxSpeed -= trunkVolume;
         
          if(gear.equalsIgnoreCase("Manuel"))
                 maxSpeed += 35;
          
            if(maxSpeed > 225)
                maxSpeed = 225;
   
        return maxSpeed;     
    }

    @Override
    public String toString() {
        return  "\n#Bus" + 
                super.toString() +
                "\nNumber of Floors: " + numOfFloors + 
                "\nStretched: "+ stretched +
                "\nNumber of Seats: " + numOfSeats + 
                "\nTrunk Volume: " + trunkVolume +  " m^3" + 
                "\n|->Maximum Speed: " +calcMaxSpeed() +" km/h" +
                "\n|->Total Price: "+ String.format("%,.0f", calculateNewPrice()) +"$";
    }
}