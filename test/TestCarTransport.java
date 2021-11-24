import CarLab.CarTransport;
import CarLab.Saab95;
import CarLab.Scania;
import CarLab.Volvo240;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarTransport {

    @Test
    public void carTransport_load_and_unload_cars() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", 4);
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        carTran.lowerRamp();
        carTran.loadCar(saab95);
        carTran.loadCar(volvo240);
        assertEquals(volvo240, carTran.unLoadCar());
        assertEquals(saab95, carTran.unLoadCar());
    }

    @Test
    public void carTransport_should_fail_to_load_car_if_ramp_is_raised() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", 4);
        Saab95 saab95 = new Saab95();
        carTran.raiseRamp();
        assertFalse(carTran.loadCar(saab95));

    }
}
