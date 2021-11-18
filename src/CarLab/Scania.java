package CarLab;

import java.awt.*;

public class Scania extends Car {

    private final Ramp ramp;

    public Scania() {
        super(2,100,Color.white,"CarLab.Scania");
        ramp = new Ramp(4, 70);
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        if (ramp.getRampAngle() == 0) {
            return getEnginePower() * 0.01;
        }
        else{
            return 0;
        }
    }
}
