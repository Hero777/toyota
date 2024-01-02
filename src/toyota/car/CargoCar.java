package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class CargoCar extends Car{
    private int capacity;

    public CargoCar(Countries country,
                    String color,
                    int maxSpeed,
                    Transmission transmission,
                    Wheel[] wheels,
                    GasTank gasTank,
                    Engine engine,
                    Electric electric,
                    Headlights headlights,
                    double price,
                    int capacity) {
        super(country, color, maxSpeed, transmission, wheels,
                gasTank, engine, electric, headlights, price);
        this.capacity = capacity;
    }
}
