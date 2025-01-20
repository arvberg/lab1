import java.awt.*;

public class Cars implements Movable{

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public Point position; // The car's current position
    public String direction; // The car's current direction

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


    public void move(){
        switch (direction) {
            case "left" -> position.x--;
            case "right" -> position.x++;
            case "up" -> position.y++;
            case "down" -> position.y--;
            default -> {
            }
        }
    }

    public void TurnLeft(){
        switch (direction) {
            case "left" -> direction = "down";
            case "right" -> direction = "up";
            case "up" -> direction = "left";
            case "down" -> direction = "right";
            default -> {}
            }
        }

    public void TurnRight(){
        switch (direction) {
            case "left" -> direction = "up";
            case "right" -> direction = "down";
            case "up" -> direction = "right";
            case "down" -> direction = "left";
            default -> {
            }
        }
    }
}


