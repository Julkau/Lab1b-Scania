package CarLab;

import java.awt.*;

public class Scania extends Car {
    private final Platform platform;

    public Scania() {
        super(2,100,Color.white,"CarLab.Scania");
        platform = new Platform(4);
    }

    @Override
    protected double speedFactor() {
        if (platform.getAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }
    // TODO: Should throw exception instead if trying to raise ramp while driving?
    public void raisePlatform(double amount) {
        if (getCurrentSpeed() == 0) {
            platform.raisePlatform(amount);
        }
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?
    public void lowerPlatform(double amount) {
        if (getCurrentSpeed() == 0) {
            platform.lowerPlatform(amount);
        }
    }

    /**
     * Getter for the attribute rampAngle in the ramp object.
     * @return the angle of the ramp as double.
     */
    public double getRampAngle(){
        return platform.getAngle();
    }
}
