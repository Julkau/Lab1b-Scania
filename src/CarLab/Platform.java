package CarLab;

//TODO: Gör ett inteface "angledRamp" eller dylikt så kan Scanias ramp vara lite mer felxibel.
public class Platform {
    private final double maxRampAngle;
    private double platformAngle;

    public Platform(double maxRampAngle) {
        this.platformAngle = 0;
        this.maxRampAngle = maxRampAngle;
    }

    /**
     * Raise ramp increases the angle of the ramp, represented by increasing rampAngle to a max angle of maxRampAngle.
     * @param amount The amount to increase rampAngle by.
     */
    public void raisePlatform(double amount) {
        platformAngle = Math.min(getAngle() + amount, maxRampAngle);
    }

    /**
     * Lower ramp reduces the angle of the ramp, represented by reducing rampAngle, to a min angle of 0.
     * @param amount The amount to reduce rampAngle by.
     */
    public void lowerPlatform(double amount) {
        platformAngle = Math.max(getAngle() - amount, 0);
    }

     /**
     * Getter for the attribute rampAngle
     * @return Returns double value from rampAngle
     */
    public double getAngle() {
        return platformAngle;
    }
}
