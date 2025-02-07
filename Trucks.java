/*
 * import java.awt.*;
 * 
 * public abstract class Trucks extends Cars {
 * int flatbedAngle = 0;
 * 
 * public Trucks(int nrDoors, double enginePower, Color color, String modelName)
 * {
 * super(nrDoors, enginePower, color, modelName);
 * }
 * 
 * @Override
 * public void startEngine() {
 * if (flatbedAngle > 0) {
 * throw new
 * IllegalArgumentException("Can't move vehicle while the flatbed is tilted.");
 * }
 * super.startEngine();
 * }
 * 
 * @Override
 * protected double speedFactor() {
 * return 1;
 * }
 * }
 */