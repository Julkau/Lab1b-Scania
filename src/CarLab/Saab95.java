package CarLab;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
        super();
        nrDoors = 2;
        this.color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "CarLab.Saab95";
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
