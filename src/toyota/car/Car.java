package toyota.car;


import toyota.exceptions.StartCarException;
import toyota.car.parts.Transmission;
import toyota.car.parts.Wheel;
import toyota.car.parts.GasTank;
import toyota.car.parts.Engine;
import toyota.car.parts.Electric;
import toyota.car.parts.Headlights;
import toyota.factory.Countries;

public abstract class Car {
    protected final Countries country;
    protected final String color;
    protected final int maxSpeed;
    protected final Transmission transmission;
    protected boolean isMove;
    protected final Wheel[] wheels;

    protected final GasTank gasTank;
    protected final Engine engine;
    protected final Electric electric;
    protected final Headlights headlights;
    protected final double price;

    public Car(Countries country, String color, int maxSpeed,
               Transmission transmission, Wheel[] wheels,
               GasTank gasTank, Engine engine, Electric electric,
               Headlights headlights, double price) {
        this.country = country;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmission = transmission;
        this.wheels = wheels;
        this.gasTank = gasTank;
        this.engine = engine;
        this.electric = electric;
        this.headlights = headlights;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public void startCar() throws StartCarException {
        String problemMessage = "";
        if (!checkWheels()) {
            problemMessage += "Ошибка: колесо не в порядке;\n";
        }
        if (gasTank.getAmountOfGas() == 0) {
            problemMessage += "Ошибка: бак пустой;\n";
        }
        if (!electric.getIsElectricOK()) {
            problemMessage += "Ошибка: электрика не исправна;\n";
        }
        if (!engine.getIsEngineOk()) {
            problemMessage += "Ошибка: двигатель не исправен;\n";
        }
        if (!problemMessage.equals("")) {
            throw new StartCarException(problemMessage);
        }
        System.out.println("Автомобиль движется");
        setMove(true);
    }

    public boolean checkWheels() {
        if (wheels == null) {
            return false;
        } else if (wheels.length != 4) {
            return false;
        }

        for (Wheel wheel : wheels) {
            if (!wheel.getIsWheelOk()) {
                return false;
            }
        }
        return true;
    }

    public void stopCar() {
        if (isMove) {
            System.out.println("Автомобиль остановился");
            setMove(false);
        }
    }

    public void headLightsOn() {
        if (headlights.getIsHeadlightsOk()) {
            System.out.println("Фары включены");
        }
    }

    public void headLightsOff() {
        if (headlights.getIsHeadlightsOk()) {
            System.out.println("Фары выключены");
        }
    }

    public void setFuel(int value) {
        gasTank.setAmountOfGas(value);
    }
}