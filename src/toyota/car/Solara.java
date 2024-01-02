package toyota.car;

import toyota.car.parts.*;
import toyota.factory.Countries;

public class Solara extends CabrioletCar {
    private boolean miniFridge;

    public Solara(Countries country,
                  String color,
                  int maxSpeed,
                  Transmission transmission,
                  Wheel[] wheels,
                  GasTank gasTank,
                  Engine engine,
                  Electric electric,
                  Headlights headlights,
                  double price,
                  boolean isRoof,
                  boolean miniFridge) {
        super(country, color, maxSpeed, transmission, wheels,
                gasTank, engine, electric, headlights, price, isRoof);
        this.miniFridge = miniFridge;
    }

    public void miniFridgeOn() {
        this.miniFridge = true;
        System.out.println("Охладить напиток включена");
    }

    public void miniFridgeOff() {
        this.miniFridge = false;
        System.out.println("Охладить напиток выключена");
    }
}
