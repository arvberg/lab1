import java.awt.*;

public class Saab95 extends Cars {

    public Saab95() {
        super(2, Color.red, 125, "Saab95");
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (isTurboOn())
            turbo = 1.3;

        return getEnginePower() * 0.01 * turbo;

    }
}