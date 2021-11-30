package CarLab;

import java.awt.*;

/**
 * Class that represents Scania Trucks; Is a subclass of Car; Has a platform for loading, transporting and unloading cars.
 * @see Car
 * @see Platform
 */
public class Scania extends Car {
    private final Platform platform;

    /**
     * Constructor for Scania; Inputs number of doors, engine power, length, color and the model name of the car;
     * Creates Platform object and puts reference in platform
     *
     * @param licensePlate is an id-name
     */
    public Scania(String licensePlate) {
        super(2, 100, 5, Color.white, "CarLab.Scania", licensePlate);
        platform = new Platform(4);
    }

    /**
     * Method for getting scania's speed factor, used when gassing
     *
     * @return Returns speedfactor for Scania class
     */
    @Override
    protected double speedFactor() {
        if (platform.getAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?

    /**
     * Method for raising the platform by a desired amount.
     *
     * @param amount amount The amount of degrees to raise the ramp  by
     */
    public void raisePlatform(double amount) {
        if (getCurrentSpeed() == 0) {
            platform.raise(amount);
        }
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?

    /**
     * Method for lowering the platform by a desired amount.
     *
     * @param amount The amount of degrees to lower the ramp  by
     */
    public void lowerPlatform(double amount) {
        if (getCurrentSpeed() == 0) {
            platform.lower(amount);
        }
    }

    /**
     * Getter for the attribute rampAngle in the ramp object.
     *
     * @return the angle of the ramp as double.
     */
    public double getRampAngle() {
        return platform.getAngle();
    }
}
