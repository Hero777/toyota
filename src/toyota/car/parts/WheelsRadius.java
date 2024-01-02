package toyota.car.parts;

public enum WheelsRadius{
    SIXTEEN(16),
    SEVENTEEN(17),
    TWENTY(20);

    private int size;

    WheelsRadius(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
