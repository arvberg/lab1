
import java.awt.*;

public class Scania extends Cars implements HasFlatBed {
    private int flatbedAngle = 0;

    public Scania() {
        super(4, 700, Color.WHITE, "Scania");
    }

    // Helper method to adjust the ramp angle by a given change
    private void adjustRamp(int change) {
        if (this.getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Can't adjust ramp while the vehicle is moving.");
        }
        flatbedAngle = Math.min(Math.max(flatbedAngle + change, 0), 70);
    }

    public void raiseRamp() {
        adjustRamp(10);
    }

    public void lowerRamp() {
        adjustRamp(-10);
    }

    public void setRampAngle(int angle) {
        if (angle < 0 || angle > 70) {
            throw new IllegalArgumentException("Invalid angle, must be between 0 and 70.");
        }
        flatbedAngle = angle;
    }

    public int getFlatBedAngle() {
        return flatbedAngle;
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
