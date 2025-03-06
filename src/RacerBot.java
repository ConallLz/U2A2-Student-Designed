/*
 * Progammer: Conall Lorentz and Charles Damian
 * Dates:
*/
import becker.robots.*;
import java.util.Random;

public abstract class RacerBot extends RobotSE {
    // Constructor
    /**
     * @param city - Starting city
     * @param x - Starting x position
     * @param y - Starting y position
     * @param direction - Starting direction
     * @param items - Starting items
     */
    public RacerBot(City city, int x, int y, Direction direction, int items) {
        super(city, y, x, direction, items);
    }

    public int getCityThingCount() {
        City city = this.getCity();
        IPredicate thingCountIPredicate = city.getThingCountPredicate();
        IIterate<Thing> thingCountIIterate = city.examineThings(thingCountIPredicate);
        int count = 0;

        while (thingCountIIterate.hasNext()) {
            thingCountIIterate.next();
            count++; 
        }

        return count;
    }

    public Thing getRandomThing() {
        City city = this.getCity();
        IPredicate thingCountIPredicate = city.getThingCountPredicate();
        IIterate<Thing> thingCountIIterate = city.examineThings(thingCountIPredicate);

        int count = getCityThingCount();
        Random random = new Random();
        int randomIndex = random.nextInt(count);
        Thing currentThing = null;

        for (int i = 0; i < randomIndex; i++) {
            currentThing = thingCountIIterate.next();
        }

        return currentThing;
    }

    @Override
    public void move(int i) {
        int y = super.getAvenue();
        int things = super.countThingsInBackpack();
        
        for (int j = 0; j < i; j++) {
            if (y > 19 && things < 2 || !super.frontIsClear()) { break; }
            super.move();
            y = super.getAvenue();
            things = super.countThingsInBackpack();
        }
    }
}