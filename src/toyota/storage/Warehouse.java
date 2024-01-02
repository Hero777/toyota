package toyota.storage;

import toyota.car.*;
import toyota.exceptions.WrongValueWarehouseException;
import toyota.factory.Countries;

public class Warehouse {
    private int amountAllCars = 0;
    private Countries country;


    private Camry[] camries = new Camry[0];
    private Solara[] solaras = new Solara[0];
    private Hiance[] hiances = new Hiance[0];
    private Dyna[] dynas = new Dyna[0];

    public Warehouse(Countries country) {
        this.country = country;
    }

    public void addCamry(Camry camry) throws WrongValueWarehouseException {
        if(amountAllCars < 1000) {
            Camry[] temp = new Camry[camries.length + 1];
            for (int i = 0; i < camries.length; i++) {
                temp[i] = camries[i];
            }
            temp[camries.length] = camry;
            camries = temp;
            amountAllCars++;
        } else {
            throw new WrongValueWarehouseException("Склад полный");
        }
    }
    public Camry getCamry() throws WrongValueWarehouseException {
        if (camries.length > 0) {
            Camry camry = camries[camries.length - 1];
            Camry[] temp = new Camry[camries.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = camries[i];
            }
            camries = temp;
            amountAllCars--;
            return camry;
        } else {
            throw new WrongValueWarehouseException("Camry на складе нет");
        }
    }

    public void addSolara(Solara solara) throws WrongValueWarehouseException {
        if(amountAllCars < 1000) {
            Solara[] temp = new Solara[solaras.length + 1];
            for (int i = 0; i < solaras.length; i++) {
                temp[i] = solaras[i];
            }
            temp[solaras.length] = solara;
            solaras = temp;
            amountAllCars++;
        } else {
            throw new WrongValueWarehouseException("Склад полный");
        }
    }
    public Solara getSolara() throws WrongValueWarehouseException {
        if (solaras.length > 0) {
            Solara solara = solaras[solaras.length - 1];
            Solara[] temp = new Solara[solaras.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = solaras[i];
            }
            solaras = temp;
            amountAllCars--;
            return solara;
        } else {
            throw new WrongValueWarehouseException("Solara на складе нет");
        }
    }


    public void addHiance(Hiance hiance) throws WrongValueWarehouseException {
        if(amountAllCars < 1000) {
            Hiance[] temp = new Hiance[hiances.length + 1];
            for (int i = 0; i < hiances.length; i++) {
                temp[i] = hiances[i];
            }
            temp[hiances.length] = hiance;
            hiances = temp;
            amountAllCars++;
        } else {
            throw new WrongValueWarehouseException("Склад полный");
        }
    }
    public Hiance getHiance() throws WrongValueWarehouseException {
        if (hiances.length > 0) {
            Hiance hiance = hiances[hiances.length - 1];
            Hiance[] temp = new Hiance[hiances.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = hiances[i];
            }
            hiances = temp;
            amountAllCars--;
            return hiance;
        } else {
            throw new WrongValueWarehouseException("Hiance на складе нет");
        }
    }
    public void addDyna(Dyna dyna) throws WrongValueWarehouseException {
        if(amountAllCars < 1000) {
            Dyna[] temp = new Dyna[dynas.length + 1];
            for (int i = 0; i < dynas.length; i++) {
                temp[i] = dynas[i];
            }
            temp[dynas.length] = dyna;
            dynas = temp;
            amountAllCars++;
        } else {
            throw new WrongValueWarehouseException("Склад полный");
        }
    }
    public Dyna getDyna() throws WrongValueWarehouseException {
        if (dynas.length > 0) {
            Dyna dyna = dynas[dynas.length - 1];
            Dyna[] temp = new Dyna[dynas.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = dynas[i];
            }
            dynas = temp;
            amountAllCars--;
            return dyna;
        } else {
            throw new WrongValueWarehouseException("Dyna на складе нет");
        }
    }

    public int getNumberOfAllCamries() {
        return camries.length;
    }

    public int getNumberOfAllSolaras() {
        return solaras.length;
    }

    public int getNumberOfAllHiances() {
        return hiances.length;
    }

    public int getNumberOfAllDynas() {
        return dynas.length;
    }

    public int getAmountAllCars() {
        return amountAllCars;
    }
}
