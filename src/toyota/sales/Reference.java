package toyota.sales;

public enum Reference {
    CAMRY(5000),
    SOLARA(8000),
    HIANCE(10000),
    DYNA(12000);

    private int price;
    Reference(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
