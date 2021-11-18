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
        if (rampAngle == 0) {
            return enginePower * 0.01;
        }
        else{
            return 0;
        }
    }
}
