/*
 * Progammer: Charles Damian
 * Dates:
*/
import becker.robots.*;
import java.awt.Color;

public class RobD extends RacerBot {
    // Constructor
    /**
     * @param city - Starting city
     * @param x - Starting x position
     * @param y - Starting y position
     * @param direction - Starting direction
     * @param items - Starting items
     */
    public RobD(City city, int x, int y, Direction direction, int items) {
        super(city, x, y, direction, items);
        this.setColor(Color.BLACK);
    }
}