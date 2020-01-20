package VehicleInheritance;

public class Truck extends Vehicle {
    
    private double payloadCapacity;
    private String trailer;
    private String cabType;
    private boolean cabinBed; 

    public Truck(String type,String brand, String model, double basePrice){
       super(type, brand, model, basePrice);
    }

    public Truck(int Id, String type, String brand, String model,
            double basePrice, boolean warranty,String color, String[] engine,String[] wheel, String gear, 
                double payloadCapacity, String trailer, String cabType, boolean cabinBed) {
        
        super(Id, type, brand, model, basePrice, warranty, color, engine, wheel, gear);
        this.payloadCapacity = payloadCapacity;
        this.trailer = trailer;
        this.cabType = cabType;
        this.cabinBed = cabinBed;
    }

@Override
    public double calculateNewPrice() {
       
        double new_price=basePrice;
        String engineType = engine[0];
        int horsePower=Integer.parseInt(engine[1]);
        double cap = Double.parseDouble(engine[2]);
        int torque = Integer.parseInt(engine[3]);
        
        new_price += horsePower*200;
        new_price += torque *40;
        new_price += cap *1500;
        
             if(engineType.equalsIgnoreCase("Class A") || engineType.equalsIgnoreCase("Class B") )
                 new_price += 55000;
             
             if(warranty)
                 new_price+=basePrice*15/100;
             if(gear.equalsIgnoreCase("Automatic"))
                 new_price+=2150;
             
    
                 new_price+= payloadCapacity * 1000;
             
             if(trailer.equalsIgnoreCase("Tank Trailer"))
                 new_price+=100000;
             else if(trailer.equalsIgnoreCase("Tilt Trailer"))
                 new_price+=150000;
             else if(trailer.equalsIgnoreCase("Pole Trailer"))
                 new_price+=70000;
      
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
        maxSpeed += torq *0.02;
        maxSpeed += cap *5;
                
         maxSpeed -= payloadCapacity* 1;

         if(!(trailer.equalsIgnoreCase("None")))
             maxSpeed -= 20;
         if(gear.equalsIgnoreCase("Manuel"))
                 maxSpeed += 45;
         
         if(maxSpeed > 210)
             maxSpeed = 210;
   
        return maxSpeed;   

    }

    @Override
    public String toString() {
        return 
                "\n#Truck" + 
                super.toString()+
                "\nPayload Capacity: " + payloadCapacity + " ton" +
                "\nTrailer Type: " + trailer + 
                "\nCabin Type: " + cabType + 
                "\nCabin Bed: " + cabinBed + 
                "\n|->Maximum Speed: " +calcMaxSpeed() +" km/h" +
                "\n|->Total Price: "+ String.format("%,.0f", calculateNewPrice()) +"$";
    }

}