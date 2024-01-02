package toyota.sales;

import toyota.car.*;
import toyota.exceptions.NotEnoughMoneyException;
import toyota.exceptions.WrongValueWarehouseException;
import toyota.factory.Conveyor;
import toyota.factory.Countries;
import toyota.storage.Warehouse;

import java.io.FileWriter;
import java.io.IOException;

public class Manager {
    private String name;
    private Conveyor conveyor;
    private Warehouse warehouse;

    private Report report = new Report(name);
    private double netPrice = 0;
    private double sumPrice = 0;
    private double sumNetPrice = 0;

    public Manager(String name, Conveyor conveyor, Warehouse warehouse) {
        this.name = name;
        this.conveyor = conveyor;
        this.warehouse = warehouse;
    }

    public int carsSold() {
        return report.getCars().length;
    }

    public Car sellCar(Customer customer) throws NotEnoughMoneyException {
        try {
            if (customer.getMoney() >= 22000) {
                Dyna dyna = warehouse.getDyna();
                report.carSaleReport(dyna);
                return dyna;
            } else if (customer.getMoney() >= 15000) {
                Hiance hiance = warehouse.getHiance();
                report.carSaleReport(hiance);
                return hiance;
            } else if (customer.getMoney() >= 12000) {
                Solara solara = warehouse.getSolara();
                report.carSaleReport(solara);
                return solara;
            } else if (customer.getMoney() >= 10000) {
                Camry camry = warehouse.getCamry();
                report.carSaleReport(camry);
                return camry;
            } else {
                throw new NotEnoughMoneyException("Проблема с деньгами");
            }
        } catch (WrongValueWarehouseException e) {
            if (customer.getMoney() >= 22000) {
                Dyna dyna = conveyor.createDyna(Countries.JAPAN, "black", 22000);
                report.carSaleReport(dyna);
                return dyna;
            } else if (customer.getMoney() >= 15000) {
                Hiance hiance = conveyor.createHiance(Countries.JAPAN, "black", 15000);
                report.carSaleReport(hiance);
                return hiance;
            } else if (customer.getMoney() >= 12000) {
                Solara solara = conveyor.createSolara(Countries.JAPAN, "white", 12000);
                report.carSaleReport(solara);
                return solara;
            } else {
                Camry camry = conveyor.createCamry(Countries.JAPAN, "black", 10000);
                report.carSaleReport(camry);
                return camry;
            }
        }
    }

    public void generateReport() throws IOException {
        try (FileWriter writer = new FileWriter("Отчет_" + this.name + ".txt", false)) {
            writer.write(this.name + "\n");
            Car[] soldCars = report.getCars();
            for (Car car : soldCars) {
                if (car instanceof Camry) {
                    netPrice = Reference.CAMRY.getPrice();
                } else if (car instanceof Solara) {
                    netPrice = Reference.SOLARA.getPrice();
                } else if (car instanceof Hiance) {
                    netPrice = Reference.HIANCE.getPrice();
                } else if (car instanceof Dyna) {
                    netPrice = Reference.DYNA.getPrice();
                }
                String topSentence = "Модель: " + car.getClass().getSimpleName() +
                        " - " + "Стоимость продажи: " + car.getPrice() +
                        " - " + "Себестоимость: " + netPrice;
                writer.write(topSentence + "\n");
                sumPrice += car.getPrice();
                sumNetPrice += netPrice;
            }
            String bottomSentence = "Итог: доходы - " + sumPrice +
                    ", расходы " + sumNetPrice +
                    ", прибыль - " + (sumPrice - sumNetPrice);

            writer.write(bottomSentence + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
