package toyota.car.parts;

public class Engine {
    private boolean isEngineOk;

    public Engine(boolean isEngineOk) {
        this.isEngineOk = isEngineOk;
    }

    public boolean getIsEngineOk() {
        return isEngineOk;
    }

    public void setEngineOk(boolean engineOk) {
        isEngineOk = engineOk;
    }
}
