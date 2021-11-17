package CarLab;

import java.awt.*;

public class Scania extends Car {

    private double rampAngle;

    public Scania() {
        super();
        rampAngle = 0;
        nrDoors = 2;
        this.color = Color.white;
        enginePower = 100;
        modelName = "CarLab.Scania";
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    public void raiseRamp() {

    }

    public void lowerRamp() {

    }

}
