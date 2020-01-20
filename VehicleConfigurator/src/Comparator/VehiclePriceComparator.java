package Comparator;

import java.util.Comparator;
import VehicleInheritance.*;

public class VehiclePriceComparator implements Comparator<Vehicle> {
    
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        if (v2.calculateNewPrice()< v1.calculateNewPrice()) return -1;
        if (v1.calculateNewPrice() > v2.calculateNewPrice()) return 1;
        return 0;
    }
}