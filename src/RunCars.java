import CarLab.Saab95;
import CarLab.Volvo240;
import CarLab.Workshop;

import java.awt.*;

public class RunCars {
    public static void main(String[] arg) {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();

        System.out.println("Cars: " + volvo + " " + saab);
    }
}
