package CarLab;

import java.awt.*;

public class Scania extends Car {

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

    /**
     * Load car to the ramp object.
     * @param car The Car object to be added to the cars stack.
     * @return boolean if the action succeeded and the car could be loaded.
     */
    public void loadCar(Car car) {
        ramp.loadCar(car);
    }

    // TODO: Must handle the possible exception from the ramp-class (if no car is on ramp).
    public Car unLoadCar() {
        return ramp.unLoadCar();
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?
    // TODO: Is this an "effect"-method or a "result"-method? Now it is both (and should most possible not be).
    public double raiseRamp(double amount) {
        if (getCurrentSpeed() == 0) {
            return ramp.raiseRamp(amount);
        }else{
            return (0);
        }
    }

    // TODO: Should throw exception instead if trying to raise ramp while driving?
    // TODO: Is this an "effect"-method or a "result"-method? Now it is both (and should most possible not be).
    public double lowerRamp(double amount) {
        if (getCurrentSpeed() == 0) {
            return ramp.lowerRamp(amount);
        }else{
            return (0);
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
