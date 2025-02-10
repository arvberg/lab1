import java.awt.*;

public abstract class Trucks extends Cars{

    public Trucks(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }


    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01; // Default speed factor for trucks
    }
}
