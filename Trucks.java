import java.awt.*;

public abstract class Trucks extends Cars implements Flatbed {
    private int flatbedAngle;
    private boolean flatbedUp;

    public Trucks(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.flatbedAngle = 0;
        this.flatbedUp = false;
    }

    public int getFlatbedAngle(){
        return flatbedAngle;
    }

    public boolean isFlatbedUp() {
        return flatbedUp;
    }

    public void tiltFlatbed(int angle) {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't tilt flatbed while the vehicle is moving.");
        }
        if (angle < -70 || angle > 70) {
            throw new IllegalArgumentException("Can't tilt below 0 or above 70 degrees");
        }
        if (flatbedAngle + angle <= 70 && flatbedAngle + angle >= 0) {
            flatbedAngle += angle;
        }
    }

    public void setFlatbed(boolean state){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("Cannot move flatbed while moving.");
        }
        flatbedUp = state;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01; // Default speed factor for trucks
    }
}
