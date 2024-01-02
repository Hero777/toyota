package toyota.factory;

import toyota.car.parts.*;

public class Factory {
    private Countries country;

    public Factory(Countries country) {
        this.country = country;
    }

    public Countries getCountry() {
        return country;
    }

    public GasTank createGasTank() {
        return new GasTank(0);
    }

    public Electric createElectric() {
        return new Electric(true);
    }

    public Engine createEngine() {
        return new Engine(true);
    }

    public Headlights createHeadlights() {
        return new Headlights(true);
    }

    public Wheel[] createAllWheels(WheelsRadius wheelsRadius) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel(wheelsRadius, true);
        }
        return wheels;
    }

    public Wheel createSpareWheel(WheelsRadius wheelsRadius) {
        return new Wheel(wheelsRadius, true);
    }
}
