import javax.swing.text.Position;
import java.awt.*;

public abstract class Cars implements Movable {

    // variables
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private Point position; // The car's current position
    private Direction direction; // The car's current direction

    private enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    // constructor - constructor is used to enforce open-closed principle, easier to reimplement
    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point(0, 0);//position;
        this.direction = Direction.NORTH; //direction;
    }

    // getters
    public int getNrDoors() {
        return nrDoors;
    }

    public Color getColor() {
        return color;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    // test-getter
    public Point getPosition() {
        return position;
    }

    // setters
    public void setColor(Color clr) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    // changers
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    } // .min() ensures that incrementation doesn't transcend enginePower

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    } // .max() ensures that incrementation doesn't go below 0

    protected abstract double speedFactor();

    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
        decrementSpeed(amount);
    }

    public void move() {
        if (currentSpeed > 0) {
            switch (direction) {
                case NORTH -> position.y += (int) currentSpeed;
                case EAST -> position.x += (int) currentSpeed;
                case SOUTH -> position.y -= (int) currentSpeed;
                case WEST -> position.x -= (int) currentSpeed;
                default -> {
                }
            }
        }
    }

    public void turnLeft() {
        if (direction == null) {
            throw new IllegalArgumentException("Direction must be set before turning.");
        }
        switch (direction) {
            case NORTH -> direction = Direction.WEST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
            case WEST -> direction = Direction.NORTH;
            default -> {
            }
        }
    }

    public void turnRight() {
        if (direction == null) {
            throw new IllegalArgumentException("Direction must be set before turning.");
        }
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
            default -> {
            }
        }
    }
}
