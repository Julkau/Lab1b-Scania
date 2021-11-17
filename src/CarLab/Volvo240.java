package CarLab;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super();
        nrDoors = 4;
        this.color = Color.black;
        enginePower = 100;
        modelName = "CarLab.Volvo240";
        stopEngine();
    }

    public static double getTrimFactor() {
        return trimFactor;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
