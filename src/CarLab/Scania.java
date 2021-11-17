package CarLab;

import java.awt.*;

public class Scania extends Car {

    public Scania() {
        super();
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

}
