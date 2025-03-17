/*
 * Progammer: Conall Lorentz and Charles Damian
 * Dates:  Mar. 3-17
*/
import becker.robots.*;

// Allows extra features to be added to the Thing class
public class Goals extends Thing{
    /**
     * @param city - City to add the goal to
     * @param street - Street where the goal should be
     * @param avenue - Avenue where the goal should be
     */
    Goals(City city, int street, int avenue){
        super(city, street, avenue);
    }

    // Override the getIntersection method and then call the regular getIntersection method
    // Necessary because the regular getIntersection method is protected
    @Override
    public Intersection getIntersection(){
        return super.getIntersection();
    }
}