package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class PassengerCar extends Car {
    private boolean isCruise;

    public PassengerCar(Countries country,
                        String color,
                        int maxSpeed,
                        Transmission transmission,
                        Wheel[] wheels,
                        GasTank gasTank,
                        Engine engine,
                        Electric electric,
                        Headlights headlights,
                        double price,
                        boolean isCruise) {
        super(country, color, maxSpeed, transmission, wheels,
                gasTank, engine, electric, headlights, price);
        this.isCruise = isCruise;
    }

    public void cruiseOn() {
        this.isCruise = true;
        System.out.println("Круиз включен");
    }

    public void cruiseOff() {
        this.isCruise = false;
        System.out.println("Круиз выключен");
    }
}
