/*
 * Progammer: Conall Lorentz and Charles Damian
 * Dates:  Mar. 3-17
*/
import java.util.NoSuchElementException;

import becker.robots.*;

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

    /**
     * The move to intersection method finds the actual intersection to be moved to and then using the current intersection finds a nice route to get to the intersection
     * @param intersection - The intersection to move to
     */

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
        pickAllThings();
    }
    
    /**
     * @param i - The number of times to move
     */
    @Override
    public void move(int i) {
        int y = super.getAvenue();
        int things = super.countThingsInBackpack();
        
        for (int j = 0; j < i; j++) {
            if (y > 19 && things < 2 || !super.frontIsClear()) {
                break;
            }
            
            super.move();
            y = super.getAvenue();
            things = super.countThingsInBackpack();
        }
    }

    @Override
    public void pickThing() {
        Intersection intersection = super.getIntersection();
        if (intersection.countThings() < 5 && intersection.getAvenue() == 25 && intersection.getStreet() == 5) {
            return;
        }

        super.pickThing();
    }

    @Override
    public void pickAllThings() {
        while (super.canPickThing()) {
           this.pickThing();
        }
    }
}