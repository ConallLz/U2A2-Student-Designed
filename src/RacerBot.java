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

    public Goals getRandomThing() {
        City city = this.getCity();
        IPredicate thingCountIPredicate = city.getThingCountPredicate();
        IIterate<Thing> thingCountIIterate = city.examineThings(thingCountIPredicate);

        int count = getCityThingCount();
        Random random = new Random();
        int randomIndex = random.nextInt(count);
        Goals currentThing = null;

        for (int i = 0; i < randomIndex; i++) {
            currentThing = (Goals) thingCountIIterate.next();
        }

        return currentThing;
    }

    public void moveToIntersection(Intersection intersection) {
        int avenue = super.getAvenue();
        int street = super.getStreet();
        Direction streetDirection;
        int biggerA, smallerA, biggerS, smallerS;
        Direction aveDirection;
       
        if (street > intersection.getStreet()) {
            streetDirection = Direction.NORTH;
            biggerS = street;
            smallerS = intersection.getStreet();
        } else {
            streetDirection = Direction.SOUTH;
            biggerS = intersection.getStreet();
            smallerS = street;
        }


        if(avenue < intersection.getAvenue()){
            aveDirection = Direction.EAST;
            biggerA = intersection.getAvenue();
            smallerA = avenue;
        }else{
            aveDirection = Direction.WEST;
            biggerA = avenue;
            smallerA = intersection.getAvenue();
        }
       
        while(getDirection() != streetDirection){
            turnLeft();
        }
        move(biggerS - smallerS);
       
        while(getDirection() != aveDirection){
            turnLeft();
        }
        move(biggerA - smallerA);
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