import java.awt.*;

public class Scania extends Trucks implements ITiltable{
    private int flatbedAngle;

    public Scania() {
        super(2, 700, Color.GRAY, "Scania");
        this.flatbedAngle = 0;
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

    public int getFlatbedAngle () {
        return flatbedAngle;
    }

    @Override
    public void startEngine() {
        if (getFlatbedAngle() > 0) {
            throw new IllegalArgumentException("Cannot drive while flatbed is tilted.");
        }
        super.startEngine();
    }
}