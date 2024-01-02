package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class Dyna extends CargoCar {
    private boolean socket;

    public Dyna(Countries country,
                String color,
                int maxSpeed,
                Transmission transmission,
                Wheel[] wheels,
                GasTank gasTank,
                Engine engine,
                Electric electric,
                Headlights headlights,
                double price,
                int capacity,
                boolean socket) {
        super(country, color, maxSpeed, transmission, wheels,
                gasTank, engine, electric, headlights, price, capacity);
        this.socket = socket;
    }

    public void socketOn() {
        System.out.println("Телефон заряжается");
        this.socket = true;
    }

    public void socketOff() {
        System.out.println("Телефон отключен");
        this.socket = false;
    }
}
