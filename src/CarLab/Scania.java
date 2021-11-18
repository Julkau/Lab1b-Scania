package CarLab;

import java.awt.*;

public class Scania extends Car {

    private Ramp ramp;

    public Scania() {
        super();
        ramp = new Ramp(4,70);
        nrDoors = 2;
        this.color = Color.white;
        enginePower = 100;
        modelName = "CarLab.Scania";
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        if (ramp.getRampAngle() == 0) {
            return enginePower * 0.01;
        }
        else{
            return 0;
        }
    }
}
