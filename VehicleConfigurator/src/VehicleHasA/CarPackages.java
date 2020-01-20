package VehicleHasA;

public class CarPackages {

      protected String name;
      protected String manufacturer;
      protected double price; 

    public CarPackages(String name, String manufacturer, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return  "\n Name: " + name + 
                "\n  Manufacturer: " + manufacturer + 
                "\n   Price: " + String.format("%,.0f", price) + "$";
    }

}