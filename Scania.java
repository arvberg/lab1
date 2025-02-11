import java.awt.*;

public class Scania extends Trucks {
    private double platformAgle;

    public Scania(){
        super(2, 770, Color.BLUE, "Scania");
        this.platformAgle = 0;
    }

    public double getPlatformAgle() {
        return platformAgle;
    }

    /* Raises the platform platform if the angle is between 0-70 degrees */
    public void raisePlatform(double amount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Cannot raise platform while moving");
        }
        platformAgle = Math.min(platformAgle + amount, 70);
    }
    
    /* Lowers the platform platform if the angle is between 0-70 degrees */
    public void lowerPlatform(double amount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Cannot raise platform while moving");
        }
        platformAgle = Math.max(platformAgle - amount, 0);
    }
    @Override
    public void startEngine() {
        if (getPlatformAgle() == 0) {
        super.startEngine();
        } else { 
            throw new IllegalStateException("Cannot start engine while platform is raised");
        }

    }
}
    /* }

    public double getPlatformAgle() {
        return platformAgle;
    }

    public void raisePlatform(double amount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Cannot raise platform while moving");
        }
        platformAgle = Math.min(platformAgle + amount, 70);
    }
    

    public void lowerPlatform(double amount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Cannot raise platform while moving");
        }
        platformAgle = Math.max(platformAgle - amount, 0);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.1;
    }
    @Override
    public void startEngine() {
        if (getPlatformAgle() == 0) {
        super.startEngine();
        } else { 
            throw new IllegalStateException("Cannot start engine while platform is raised");
        }

    } */

    /* @Override
    public void gas(double amount) {
        if (getPlatformAgle() > 0) {
            throw new IllegalStateException("Cannot gas while platform is raised");
        }
        super.gas(amount);
    }

    @Override
    public void move() {
        if (getPlatformAgle() == 0) {
            super.move();
        } else {
            throw new IllegalStateException("Cannot move while platform is raised");
        }
    } */
