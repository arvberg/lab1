import java.awt.*;

public class TransportTruck extends Transport<Cars> implements IRaisable{
    private boolean rampDown;

    public TransportTruck() {
        super(6); // Car transport can hold up to 6 cars
        this.rampDown = false;
    }

    public void lowerRamp() {
        rampDown = true;
    }

    public void raiseRamp() {
        if (!getLoadedVehicles().isEmpty()) {
            throw new IllegalStateException("Cannot raise    ramp while loaded.");
        }
        rampDown = false;
    }

    @Override
    public void loadVehicle(Cars car) {
        if (!rampDown) {
            throw new IllegalStateException("Ramp must be down to load a car.");
        }
        super.loadVehicle(car);
    }

    @Override
    public Cars unloadVehicle() {
        if (!rampDown) {
            throw new IllegalStateException("Ramp must be down to unload.");
        }
        return super.unloadVehicle();
    }
}
