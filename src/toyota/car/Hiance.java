package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class Hiance extends CargoCar {
    private Wheel spareWheel;

    public Hiance(Countries country,
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
                  Wheel spareWheel) {
        super(country, color, maxSpeed, transmission, wheels, gasTank,
                engine, electric, headlights, price, capacity);
        this.spareWheel = spareWheel;
    }
}
