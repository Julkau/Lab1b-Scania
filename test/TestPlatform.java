import CarLab.*;
import org.junit.jupiter.api.Test;

public class TestPlatform {

    @Test
    public void raising_ramp_angle_above_max_capacity_should_stop_at_max_capacity(){
        Platform ramp = new Platform(70);
        ramp.raise(50);
        System.out.println(ramp.getAngle());
        ramp.raise(100);
        System.out.println(ramp.getAngle());
    }

    @Test
    public void cannot_lower_ramp_below_0_degrees(){
        Platform ramp = new Platform(70);
        ramp.raise(10);
        ramp.lower(20);
        System.out.println(ramp.getAngle());

    }


}
