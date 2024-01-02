package toyota.sales;

import toyota.car.Car;

public class Cashier {
    private static double totalAccount = 0;

    public void payForCar(Car car) {
        totalAccount += car.getPrice();
    }
}
