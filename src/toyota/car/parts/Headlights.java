package toyota.car.parts;

public class Headlights {
    private boolean isHeadlightsOk;

    public Headlights(boolean isHeadlightsOk) {
        this.isHeadlightsOk = isHeadlightsOk;
    }

    public boolean getIsHeadlightsOk() {
        return isHeadlightsOk;
    }

    public void setHeadlightsOk(boolean headlightsOk) {
        isHeadlightsOk = headlightsOk;
    }
}
