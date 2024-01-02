package toyota.car.parts;

public class Electric {
    private boolean isElectricOK;

    public Electric(boolean isElectricOK) {
        this.isElectricOK = isElectricOK;
    }

    public boolean getIsElectricOK() {
        return isElectricOK;
    }

    public void setIsElectricOK(boolean electricOK) {
        isElectricOK = electricOK;
    }
}
