package CarLab;

import java.util.Stack;

public class Ramp {
    private final double maxRampAngle;
    private double rampAngle;

    public Ramp(int capacity, double maxRampAngle) {
        this.rampAngle = 0;
        this.maxRampAngle = maxRampAngle;
    }

    /**
     * Raise ramp increases the angle of the ramp, represented by increasing rampAngle to a max angle of maxRampAngle.
     * @param amount The amount to increase rampAngle by.
     * @return Returns double value from the new ramp value
     */

    public void raiseRamp(double amount) {
        rampAngle = Math.min(getRampAngle() + amount, maxRampAngle);
    }

    /**
     * Lower ramp reduces the angle of the ramp, represented by reducing rampAngle, to a min angle of 0.
     * @param amount The amount to reduce rampAngle by.
     * @return Returns double value from the new ramp value
     */
    public void lowerRamp(double amount) {
        rampAngle = Math.max(getRampAngle() - amount, 0);
    }

     /**
     * Getter for the attribute rampAngle
     * @return Returns double value from rampAngle
     */
    public double getRampAngle() {
        return rampAngle;
    }
}
