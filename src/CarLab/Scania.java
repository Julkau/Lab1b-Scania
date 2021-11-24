package CarLab;

import java.awt.*;

public class Scania extends Semi {

    private final Ramp ramp;

    public Scania() {
        super(2,100,Color.white,"CarLab.Scania");
        ramp = new Ramp(4, 70);
    }

    @Override
    protected double speedFactor() {
        if (ramp.getRampAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }




    // TODO: Should throw exception instead if trying to raise ramp while driving?
    public void raiseRamp(double amount) {
        if (getCurrentSpeed() == 0) {
            ramp.raiseRamp(amount);
        }
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?
    // TODO: Is this an "effect"-method or a "result"-method? Now it is both (and should most possible not be).
    public void lowerRamp(double amount) {
        if (getCurrentSpeed() == 0) {
            ramp.lowerRamp(amount);
        }
    }

    /**
     * Getter for the attribute rampAngle in the ramp object.
     * @return the angle of the ramp as double.
     */
    public double getRampAngle(){
        return ramp.getRampAngle();
    }
}
