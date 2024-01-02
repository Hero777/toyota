package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class CabrioletCar extends Car {
    private boolean isRoof;

    public CabrioletCar(Countries country,
                        String color,
                        int maxSpeed,
                        Transmission transmission,
                        Wheel[] wheels,
                        GasTank gasTank,
                        Engine engine,
                        Electric electric,
                        Headlights headlights,
                        double price,
                        boolean isRoof) {
        super(country, color, maxSpeed, transmission, wheels, gasTank, engine, electric, headlights, price);
        this.isRoof = isRoof;
    }

    public void isRoofOn() {
        this.isRoof = true;
        System.out.println("Крыша включена");
    }

    public void isRoofOff() {
        this.isRoof = false;
        System.out.println("Круиз выключена");
    }
}
