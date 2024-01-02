package toyota.factory;

import toyota.car.Camry;
import toyota.car.Dyna;
import toyota.car.Hiance;
import toyota.car.Solara;
import toyota.exceptions.CountyFactoryNotEqualException;
import toyota.car.parts.Transmission;
import toyota.car.parts.WheelsRadius;

public class Conveyor {
    private Factory factory;
    private Countries country;

    public Conveyor(Factory factory, Countries country) throws CountyFactoryNotEqualException {
        if (country != factory.getCountry()) {
            throw new CountyFactoryNotEqualException("Конвейер и фабрика в разных странах");
        }
        this.factory = factory;
        this.country = country;
    }

    public Camry createCamry(Countries country, String color, double price) {
        return new Camry(country, color, 180, Transmission.AUTOMATIC,
                factory.createAllWheels(WheelsRadius.SEVENTEEN),
                factory.createGasTank(), factory.createEngine(),
                factory.createElectric(), factory.createHeadlights(), price,
                true, true);
    }

    public Solara createSolara(Countries country, String color, double price) {
        return new Solara(country, color, 200, Transmission.ROBOT,
                factory.createAllWheels(WheelsRadius.SIXTEEN),
                factory.createGasTank(), factory.createEngine(),
                factory.createElectric(), factory.createHeadlights(), price,
                true, true);
    }

    public Hiance createHiance(Countries country, String color, double price) {
        return new Hiance(country, color, 130, Transmission.MANUAL,
                factory.createAllWheels(WheelsRadius.TWENTY), factory.createGasTank(),
                factory.createEngine(), factory.createElectric(), factory.createHeadlights(),
                price,2000,factory.createSpareWheel(WheelsRadius.TWENTY));
    }

    public Dyna createDyna(Countries country, String color, double price) {
        return new Dyna(country, color, 120, Transmission.MANUAL,
                factory.createAllWheels(WheelsRadius.TWENTY), factory.createGasTank(),
                factory.createEngine(), factory.createElectric(), factory.createHeadlights(),
                price, 3000, true);
    }
}
