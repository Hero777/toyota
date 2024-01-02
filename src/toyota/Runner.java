package toyota;

import toyota.car.Camry;
import toyota.car.Dyna;
import toyota.car.Hiance;
import toyota.car.Solara;
import toyota.exceptions.CountyFactoryNotEqualException;
import toyota.exceptions.NotEnoughMoneyException;
import toyota.exceptions.StartCarException;
import toyota.exceptions.WrongValueWarehouseException;
import toyota.factory.Conveyor;
import toyota.factory.Countries;
import toyota.factory.Factory;
import toyota.sales.Cashier;
import toyota.sales.Customer;
import toyota.sales.Manager;
import toyota.storage.Warehouse;

import java.io.IOException;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
        //производство
        Factory factory = new Factory(Countries.JAPAN);

        //склад
        Warehouse warehouse = new Warehouse(Countries.JAPAN);

        //конвейер
        Conveyor conveyor = null;
        try {
            conveyor = new Conveyor(factory, Countries.JAPAN);
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }

        //сборка Camry
        Camry camry = Objects.requireNonNull(conveyor).createCamry(Countries.JAPAN, "black", 10_000);
        camry.setFuel(5);
        try {
            camry.startCar();
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
        }
        camry.checkWheels();
        camry.headLightsOn();
        camry.headLightsOff();
        camry.usbFunctionOn();
        camry.usbFunctionOff();
        camry.cruiseOn();
        camry.cruiseOff();
        camry.stopCar();

        //сборка Solara
        Solara solara = conveyor.createSolara(Countries.JAPAN, "white", 12_000);
        solara.setFuel(5);
        try {
            solara.startCar();
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
        }
        solara.checkWheels();
        solara.headLightsOn();
        solara.headLightsOff();
        solara.miniFridgeOn();
        solara.miniFridgeOff();
        solara.isRoofOn();
        solara.isRoofOff();
        solara.stopCar();

        //сборка Hiance
        Hiance hiance = conveyor.createHiance(Countries.JAPAN, "black", 15_000);
        hiance.setFuel(5);
        try {
            hiance.startCar();
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
        }
        hiance.checkWheels();
        hiance.headLightsOn();
        hiance.headLightsOff();
        hiance.stopCar();

        //сборка Dyna
        Dyna dyna = conveyor.createDyna(Countries.JAPAN, "black", 22_000);
        dyna.setFuel(5);
        try {
            dyna.startCar();
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
        }
        dyna.checkWheels();
        dyna.headLightsOn();
        dyna.headLightsOff();
        dyna.socketOn();
        dyna.socketOff();
        dyna.stopCar();

        //добавляем машины на склад
        try {
            warehouse.addCamry(camry);
            warehouse.addSolara(solara);
            warehouse.addHiance(hiance);
            warehouse.addDyna(dyna);
        } catch (WrongValueWarehouseException e) {
            System.out.println(e.getMessage());
        }

        //проверка склада
        int warehouseAmountAllCars = warehouse.getAmountAllCars();
        System.out.println("Количество всех машин на складе " + warehouseAmountAllCars);

        //продажи
        Manager manager = new Manager("Olexii", conveyor, warehouse);
        Customer[] firstDayCustomers = {
                new Customer("Nick", 10000),
                new Customer("Rex", 12000),
                new Customer("Ted", 15000),
                new Customer("Bob", 22000),
                new Customer("Tom", 11000),
                new Customer("Kate", 13000),
                new Customer("Bill", 8000),
                new Customer("Tex", 30000)

        };
        //кассир заносит в общий счет
        Cashier cashier = new Cashier();
        for (Customer c : firstDayCustomers) {
            try {
                cashier.payForCar(manager.sellCar(c));
            } catch (NotEnoughMoneyException e) {
                System.out.println(e.getMessage());
            }
        }

        //сумма проданных машин
        System.out.println("Сумма проданных машин: " + manager.carsSold());

        //метод у менеджера - сгенерируй отчет
        try {
            manager.generateReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
