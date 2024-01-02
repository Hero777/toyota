package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class Camry extends PassengerCar {
    private boolean usbFunction;

    public Camry(Countries country,
                 String color,
                 int maxSpeed,
                 Transmission transmission,
                 Wheel[] wheels,
                 GasTank gasTank,
                 Engine engine,
                 Electric electric,
                 Headlights headlights,
                 double price,
                 boolean isCruise,
                 boolean usbFunction) {
        super(country, color, maxSpeed, transmission, wheels, gasTank, engine, electric, headlights, price, isCruise);
        this.usbFunction = usbFunction;
    }

    public void usbFunctionOn() {
        this.usbFunction = true;
        System.out.println("Музыка подключена");
    }

    public void usbFunctionOff() {
        this.usbFunction = false;
        System.out.println("Музыка отключена");
    }
}
