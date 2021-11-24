package CarLab;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4,100, 2.5, Color.black, "CarLab.Volvo240");
    }

    public static double getTrimFactor() {
        return trimFactor;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
