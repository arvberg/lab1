import java.awt.*;

public abstract class Cars implements Movable{

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public Point position; // The car's current position
    public String direction; // The car's current direction
    public boolean turboOn; // The car's current Turbo setting

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

    public void stopEngine(){
    currentSpeed = 0;
}

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected abstract double speedFactor();

    public void gas(double amount){
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }


    public void move(){
        if (currentSpeed > 0) {
            switch (direction) {
                case "left" -> position.x--;
                case "right" -> position.x++;
                case "up" -> position.y++;
                case "down" -> position.y--;
                default -> {
                }
            }
        }
    }

    public void TurnLeft(){
        if (direction == null){direction = "left";}
        switch (direction) {
            case "left" -> direction = "down";
            case "right" -> direction = "up";
            case "up" -> direction = "left";
            case "down" -> direction = "right";
            default -> throw new IllegalArgumentException("Invalid direction: "+direction);
            }
        }

    public void TurnRight(){
        if (direction == null){direction = "right";}
        switch (direction) {
            case "left" -> direction = "up";
            case "right" -> direction = "down";
            case "up" -> direction = "right";
            case "down" -> direction = "left";
            default -> throw new IllegalArgumentException("Invalid direction: "+direction);
        }
    }
}


