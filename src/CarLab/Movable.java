package CarLab;

/**
 * Only public methods should be here, stuff we would like to call from another class to move the Car (or other type that
 * implements Movable).
 */

public interface Movable {

    void move();

    void turnRight();

    void turnLeft();
}
