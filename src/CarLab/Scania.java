package CarLab;

import java.awt.*;

public class Scania extends Car {

    private final ScaniaRamp ramp;

    public Scania() {
        super(2,100,Color.white,"CarLab.Scania");
        ramp = new ScaniaRamp(4, 70);
    }

    @Override
    protected double speedFactor() {
        if (ramp.getRampAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }

    /**
     * Load car to the ramp object.
     * @param car The Car object to be added to the cars stack.
     * @return boolean if the action succeeded and the car could be loaded.
     */
    public boolean loadCar(Car car) {
        return ramp.loadCar(car);
    }

    // TODO: Must handle the possible exception from the ramp-class (if no car is on ramp).
    public Car unLoadCar() {
        return ramp.unLoadCar();
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?
    // TODO: Is this an "effect"-method or a "result"-method? Now it is both (and should most possible not be).
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
