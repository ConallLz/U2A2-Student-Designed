/*
 * Progammer: Conall Lorentz
 * Dates: Mar. 3-17
*/
import becker.robots.*;
import java.awt.Color;

public class RobL extends RacerBot {
    // Constructor
    /**
     * @param city - Starting city
     * @param x - Starting x position
     * @param y - Starting y position
     * @param direction - Starting direction
     * @param items - Starting items
     */
    public RobL(City city, int x, int y, Direction direction, int items) {
        super(city, x, y, direction, items);
        this.setColor(Color.WHITE);
    }
}
