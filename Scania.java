import java.awt.*;

public class Scania extends Cars implements hasFlatBed {
    private int flatbedAngle = 0;

    public Scania() {
        super(4, 700, Color.WHITE, "Scania");
    }

    public void raiseRamp() {
        if (this.getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Can't raise ramp while the vehicle is moving.");
        }
        flatbedAngle = Math.min(flatbedAngle + 1, 70);
    }

    public int getFlatBedAngle() {
        return flatbedAngle;
    }

    public void lowerRamp() {
        if (this.getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Can't lower ramp while the vehicle is moving.");
        }
        flatbedAngle = Math.max(flatbedAngle - 1, 0);
    }

    @Override
    public void startEngine() {
        if (flatbedAngle > 0) {
            throw new IllegalArgumentException("Can't move vehicle while the flatbed is tilted.");
        }
        super.startEngine();
    }

    @Override
    protected double speedFactor() {
        return 1;
    }
}
