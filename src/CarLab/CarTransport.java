package CarLab;

import java.awt.*;

/**
 * A CarTransport type for transporting Car-types. Uses a Ramp for the carrying of the Cars.
 */
public class CarTransport extends Car{
    private final Ramp ramp;

    /**
     * Creates an CarTransport and a new ramp to it.
     * @param doors is the number of car-doors.
     * @param enginePower is the enginePower and therefore the cars max speed.
     * @param color is the cars color.
     * @param name is the name of the car.
     * @param rampCapacity is the capacity (number of cars) the ramp has (can hold).
     */
    public CarTransport(int doors, double enginePower, Color color, String name, String licensePlate, int rampCapacity) {
        super(doors, enginePower, 7.5, color, name, licensePlate);
        this.ramp = new Ramp(rampCapacity, getLength()-1);
    }

    /**
     * Is the factor with which the speed is calculated. Will be zero if the ramp is lowered.
     * @return a double with the calculated speed-factor.
     */
    @Override
    protected double speedFactor() {
        if(ramp.isRaised()) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }

    /**
     * Starts the engine but removes any speed if ramp is lowered.
     */
    @Override
    public void startEngine() {
        super.startEngine();
        if(!ramp.isRaised()) {
            setCurrentSpeed(0);
        }
    }

    /**
     * Raises the ramp if the current speed is zero.
     */
    public void raiseRamp() {
        if(getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    /**
     * Lowers the ramp if the current speed is zero.
     */
    public void lowerRamp() {
        if(getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }

    /**
     * Loads a Car onto the ramp.
     * @param car is the car to be loaded onto the ramp.
     * @return boolean if the loading succeeded or not.
     */
    public void loadCar(Car car) {
        if(closeBy(car)) {
            ramp.loadCar(car);
        }
        else {
            throw new UnsupportedOperationException("Car is not close by, can't load it!");
        }
    }

    /**
     * Unloads a car from the ramp (first in, last out).
     * @return the unloaded car.
     */
    public Car unLoadCar() {
        Car car = ramp.unLoadCar();
        setUnloadCoordinate(car);
        return car;
    }

    /**
     * Sets the cars coordinate to be exactly behind the car-transport.
     * @param car is the car to set the coordinate for.
     */
    private void setUnloadCoordinate(Car car) {
        DIRECTION direction = getDirection();
        Double[] coordinate = car.getCoordinate();
        double x = coordinate[0];
        double y = coordinate[1];

        double adjustment = ((getLength()/2)+(car.getLength()/2));

        if (direction == DIRECTION.NORTH) {
            setCoordinate(x,y-adjustment);
        } else if (direction == DIRECTION.EAST) {
            setCoordinate(x-adjustment,y);
        } else if (direction == DIRECTION.SOUTH) {
            setCoordinate(x,y+adjustment);
        } else if (direction == DIRECTION.WEST) {
            setCoordinate(x+adjustment,y);
        }
    }

    /**
     * Checks if the car is close by the CarTransport.
     * @param car is the car to check.
     * @return a boolean if the car is close by (within 1  + car and truck lengths).
     */
    private boolean closeBy(Car car) {
        Double[] coordinateCar = car.getCoordinate();
        double carX = coordinateCar[0];
        double carY = coordinateCar[1];

        Double[] coordinate = getCoordinate();
        double truckX = coordinate[0];
        double truckY = coordinate[1];

        double adjustment = ((getLength()/2)+(car.getLength()/2)) + 1;

        double distance = Math.sqrt(Math.pow(carX-truckX, 2) + Math.pow(carY-truckY, 2));
        return distance <= adjustment;
    }

    @Override
    public void move() {
        super.move();
        Double[] carTransportCoordinate = getCoordinate();
        for(Car car : ramp.getCars()){
            car.setCoordinate(carTransportCoordinate);
        }
    }

    /**
     * Will also only gas if the ramp is raised.
     * @param amount is the positive amount [0,1] to accelerate, is multiplied with speedFactor in incrementSpeed.
     * @throws IllegalArgumentException
     */
    @Override
    public void gas(double amount) throws IllegalArgumentException {
        if(ramp.isRaised()) {
            super.gas(amount);
        }
    }
}
