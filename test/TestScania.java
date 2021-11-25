import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestScania {

    @Test
    public void scania_should_not_move_when_ramp_is_raised() {
        Scania scania = new Scania("abc123");
        scania.startEngine();
        scania.brake(1);
        scania.raisePlatform(10);
        scania.gas(1);
        assertEquals( 0 , scania.getCurrentSpeed());
    }

    @Test
    public void scania_should_not_move_ramp_when_moving() {
        Scania scania = new Scania("abc123");
        scania.startEngine();
        scania.gas(1);
        scania.raisePlatform(10);
        assertEquals( 0 , scania.getRampAngle());
    }
}