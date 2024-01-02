package toyota.car.parts;

public class Wheel {
    private int size;
    private boolean isWheelOk;

    public Wheel(WheelsRadius wheelsRadius, boolean isWheelOk) {
        this.size = wheelsRadius.getSize();
        this.isWheelOk = isWheelOk;
    }

    public int getSize() {
        return size;
    }

    public boolean getIsWheelOk() {
        return isWheelOk;
    }

    public void setIsWheelOk(boolean wheelOk) {
        this.isWheelOk = wheelOk;
    }
}
