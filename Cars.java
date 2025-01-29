import java.awt.*;

public abstract class Cars implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x, y; // Position
    private Direction direction; 

    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }
    
    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
        stopEngine();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine() {
	    currentSpeed = 0;
    }
    
    protected void setCurrentSpeed(double speed) {
        this.currentSpeed = Math.max(0, Math.min(speed, enginePower));
    }
    protected abstract double speedFactor();

    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() +  speedFactor() * amount);
    }
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    @Override
    public void move() {
        switch(direction) {
            case NORTH -> y += currentSpeed;
            case EAST -> x +=currentSpeed;
            case SOUTH -> y -= currentSpeed;
            case WEST -> x -= currentSpeed;
        }
    }
    public void turnLeft() {
        switch (direction) {
            case NORTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.NORTH;
        }
    }
    public void turnRight() {
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
        }
    }
}


