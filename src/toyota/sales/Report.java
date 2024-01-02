package toyota.sales;

import toyota.car.Car;

public class Report {
    private String managerName;
    private Car[] cars;

    public Report(String managerName) {
        this.managerName = managerName;
        this.cars = new Car[0];
    }

    public String getManagerName() {
        return managerName;
    }

    public Car[] getCars() {
        return cars;
    }

    public void carSaleReport(Car car) {
        Car[] temp = new Car[cars.length + 1];
        for (int i = 0; i < cars.length; i++) {
            temp[i] = cars[i];
        }
        temp[cars.length] = car;
        cars = temp;
    }
}
