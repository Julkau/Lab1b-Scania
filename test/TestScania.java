import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScania {

    @Test
    public void scania_should_not_move_when_ramp_is_raised() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.raiseRamp(10);
        scania.gas(1);
        assertEquals( 0 , scania.getCurrentSpeed());
    }

    @Test
    public void scania_should_not_move_ramp_when_moving() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.gas(1);
        assertEquals( 0 , scania.raiseRamp(10));
    }

    @Test
    public void scania_load_and_unload_cars() {
        Scania scania = new Scania();
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        scania.loadCar(saab95);
        scania.loadCar(volvo240);
        assertEquals(volvo240, scania.unLoadCar());
        assertEquals(saab95, scania.unLoadCar());
    }
}