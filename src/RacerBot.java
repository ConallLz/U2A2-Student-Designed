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
       
        //this checks the greater between the current street and the street of the intersection to be moved to, and depending on which it faces north and south
        if (street > intersection.getStreet()) {
            streetDirection = Direction.NORTH;
            biggerS = street;
            smallerS = intersection.getStreet();
        } else {
            streetDirection = Direction.SOUTH;
            biggerS = intersection.getStreet();
            smallerS = street;
        }

        //this checks the same for the avenue and depending on which is greater, it faces west or south
        if(avenue < intersection.getAvenue()){
            aveDirection = Direction.EAST;
            biggerA = intersection.getAvenue();
            smallerA = avenue;
        }else{
            aveDirection = Direction.WEST;
            biggerA = avenue;
            smallerA = intersection.getAvenue();
        }
       
        //while loop to turn left until it is facing the street direction
        while(getDirection() != streetDirection){
            turnLeft();
        }
        //this moves the difference between the current street and intersection street
        move(biggerS - smallerS);
       
        //while loop to turn left until it is facing the avenue direction
        while(getDirection() != aveDirection){
            turnLeft();
        }

        //this moves the difference between the avenue and the intersection avenue
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

    /**
     * This is the overrided method of the pick thing to check if the current thing on the intersection has already been taken
     */
    @Override
    public void pickThing() {
        Intersection intersection = super.getIntersection();
        if (intersection.countThings() < 5 && intersection.getAvenue() == 25 && intersection.getStreet() == 5) {
            return;
        }

        super.pickThing();
    }

    /**
     * This is the overrided method of the pickAllThings to ensure the version of pickThing used is the overrided pickthing of the class
     */
    @Override
    public void pickAllThings() {
        while (super.canPickThing()) {
           this.pickThing();
        }
    }
}