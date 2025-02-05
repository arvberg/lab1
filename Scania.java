import java.awt.*;

public class Scania extends Cars{
    int flatbedAngle = 0;

    public Scania(){
        super(4, 700, Color.WHITE, "Scania");
    }

    protected void tiltFlatbed(int degrees){
        if (degrees < -70 || degrees > 70){
            throw new IllegalArgumentException("Can't tilt below 0 or above 70 degrees");
        }
        if (flatbedAngle + degrees <= 70 && flatbedAngle + degrees >= 0){
            flatbedAngle += degrees;
        }
    }

    protected void inputAngle(int degrees){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("Can't tilt flatbed while the vehicle is moving.");
        }
        tiltFlatbed(degrees);
    }

    @Override
    public void startEngine(){
        if (flatbedAngle > 0){
            throw new IllegalArgumentException("Can't move vehicle while the flatbed is tilted.");
        }
        super.startEngine();
    }

    @Override
    protected double speedFactor() {
        return 1;
    }
}
