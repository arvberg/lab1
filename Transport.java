import java.awt.*;

public class Transport extends Trucks implements IRaisable{
    private boolean flatbedUp;

    public Transport() {
        super(2, 800, Color.RED, "VAH");
        this.flatbedUp = false;
    }


    public void setFlatbed(boolean state){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("Cannot move flatbed while moving.");
        }
        flatbedUp = state;
    }

    public void raiseFlatBed(){
        if (flatbedUp){
            throw new IllegalArgumentException("Flatbed already raised.");
        }
        setFlatbed(true);
    }

    public void lowerFlatBed(){
        if (!flatbedUp){
            throw new IllegalArgumentException("Flatbed already lowered.");
        }
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("Cannot lower flatbed while moving.");
        }
    }

    public boolean isFlatbedUp() {
        return flatbedUp;
    }

    @Override
    public void startEngine() {
        if (!isFlatbedUp()) {
            throw new IllegalArgumentException("Cannot drive while flatbed is down.");
        }
        super.startEngine();
    }

}
