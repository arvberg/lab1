import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;

public class CarTransport extends Trucks {
    private ArrayList<Cars> carSpace = new ArrayList<>();
    private int maxSize = 6; 
    private String ramp;

    public CarTransport() {
        super(2, 500, Color.WHITE, "CarTransport");
        this.ramp = "up";
    }

    public void addCar(Cars car) {
        if (maxSize == carSpace.size()) {
            throw new IllegalStateException("Transport is maxed out!");
        } else {
            carSpace.add(car);
        }
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {}
        this.ramp = "up";
    }

    public void lowerRamp() {
        this.ramp = "down";
    }
    public String getRampPosition() {
        return this.ramp;
    }
}