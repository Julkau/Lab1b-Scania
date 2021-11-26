package CarLab;

import java.awt.*;


public abstract class Car implements Movable {

    private double x;
    private double y;
    private DIRECTION direction;
    private boolean engineOn;
    private double currentSpeed;
    private double length;
    private final String licensePlate;

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    /**
     *  Creates a new car.
     * @param nrDoors, the amount of doors of the car.
     * @param enginePower, the engine power of the car.
     * @param color, the colour of the car.
     * @param modelName, which type of car it is.
     * @param length, the length of the car.
     */
    public Car(int nrDoors, double enginePower, double length, Color color, String modelName, String licensePlate) {
        this.x = 0;
        this.y = 0;
        this.direction = DIRECTION.NORTH;
        this.engineOn = false;
        this.currentSpeed = 0;
        this.length = length;
        this.licensePlate = licensePlate;

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Method to get the speed factor of the car.
     */
    protected abstract double speedFactor();

    /**
     * Gets amount of doors on the car.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Gets the engine power of the car.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gets the current speed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Gets the colour of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Checks if the engine is on, returns a true or false statement.
     */
    public boolean getEngineOn() {
        return engineOn;
    }

    /**
     * Gets the length of the car.
     * @return a double.
     */

    public double getLength(){
        return length;
    }

    /**
     * Gets the current coordinate in doubles.
     *
     * @return Integer array of coordinate x and y [-,+].
     */
    public Double[] getCoordinate() {
        return new Double[]{this.x, this.y};
    }

    /**
     * Sets the coordinates of the car from the list coordinate.
     */
    public void setCoordinate(Double[] coordinate) {
        this.x = coordinate[0];
        this.y = coordinate[1];
    }

    /**
     * Sets the coordinates of the car by two doubles.
     * @param x, the x coordinate of the car.
     * @param y, the y coordinate of the car.
     */
    public void setCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the current direction of a car as either NORTH, EAST, SOUTH or WEST.
     */
    public DIRECTION getDirection() {
        return direction;
    }

    /**
     * Gets the license plate of the car.
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets the colour of a car.
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine of the car.
     */
    public void startEngine() {
        currentSpeed = 0.1;
        engineOn = true;
    }

    /**
     * Stops the engine of a car.
     */
    public void stopEngine() {
        currentSpeed = 0;
        engineOn = false;
    }


    /**
     * Move x or y in direction based on DIRECTION of instance Car. Positive y is north, positive x is east.
     */
    @Override
    public void move() {
        if (direction == DIRECTION.NORTH) {
            y += getCurrentSpeed();
        } else if (direction == DIRECTION.EAST) {
            x += getCurrentSpeed();
        } else if (direction == DIRECTION.SOUTH) {
            y -= getCurrentSpeed();
        } else if (direction == DIRECTION.WEST) {
            x -= getCurrentSpeed();
        }
    }

    /**
     * Switches the direction of the car by using the enum DIRECTION. direction.left moves the index to the
     * "previous" item in the list directionValues.
     */
    @Override
    public void turnLeft() {
        direction = direction.left(direction);
    }

    /**
     * Switches the direction of the car by using the enum DIRECTION. direction.right moves the index to the "next"
     * item in the list directionValues.
     */
    @Override
    public void turnRight() {
        direction = direction.right(direction);
    }


    /**
     * Increments speed based on class-factors. Speed should not go above enginePower or below zero.
     *
     * @param amount is the positive amount to increase.
     */
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decreases speed based on class-factors. Speed should not go above enginePower or below zero.
     *
     * @param amount is the positive amount to decrease.
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Gas method will accelerate with increaseSpeed() but only if engine is on.
     *
     * @param amount is the positive amount [0,1] to accelerate, is multiplied with speedFactor in incrementSpeed.
     */
    public void gas(double amount) throws IllegalArgumentException {
        if(1 - amount < 0 || 1 - amount > 1) {
            throw new IllegalArgumentException("Gas amount should be within [0,1]");
        }
        if (engineOn) {
            incrementSpeed(amount);
        }
    }

    /**
     * Brake method will decelerate with decrementSpeed().
     *
     * @param amount is the positive amount [0,1] to decelerate, is multiplied with speedFactor in decrementSpeed.
     */
    public void brake(double amount) throws IllegalArgumentException {
        if(1 - amount < 0 || 1 - amount > 1) {
            throw new IllegalArgumentException("Brake amount should be within [0,1]");
        }
        if(amount > currentSpeed)
            amount = currentSpeed;
        decrementSpeed(amount);
    }

    /**
     * Direction enum with NORTH, EAST, SOUTH, and WEST. The methods right() and left() should wrap around the
     * directions (West goes to North, and North goes to West).
     */
    public enum DIRECTION {
        NORTH, EAST, SOUTH, WEST;

        private static final DIRECTION[] directionValues = values();

        public DIRECTION right(DIRECTION direction) {
            return directionValues[(direction.ordinal() + 1) % directionValues.length];
        }

        public DIRECTION left(DIRECTION direction) {
            if (direction.equals(NORTH)){
                return WEST;
            } else {
                return directionValues[(direction.ordinal() - 1)];
            }
        }
    }
}
