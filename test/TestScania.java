import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestScania {

    @Test
    public void scania_ramp_should_start_at_0_degree_angle() {
        Scania scania = new Scania();
        assertEquals(0, scania.getRampAngle());
    }

    @Test
    public void scania_should_not_load_car_when_ramp_is_not_at_70_degrees() {
        Scania scania = new Scania();
        Saab95 saab95 = new Saab95();
        assertFalse(scania.loadCar(saab95));
    }

    @Test
    public void scania_should_have_max_angle_of_70_degrees() {
        Scania scania = new Scania();
        scania.raiseRamp(100);
        assertEquals(70, scania.getRampAngle());
    }

    @Test
    public void scania_load_and_unload_cars() {
        Scania scania = new Scania();
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        scania.raiseRamp(70);
        scania.loadCar(saab95);
        scania.loadCar(volvo240);
        assertEquals(volvo240, scania.unLoadCar());
        assertEquals(saab95, scania.unLoadCar());
    }

    @Test
    public void scania_should_not_move_when_ramp_is_raised() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.brake(1);
        scania.raiseRamp(10);
        scania.gas(1);
        assertEquals( 0 , scania.getCurrentSpeed());
    }

    @Test
    public void scania_should_not_move_ramp_when_moving() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.gas(1);
        scania.raiseRamp(10);
        assertEquals( 0 , scania.getRampAngle());
    }
}