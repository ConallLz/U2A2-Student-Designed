  /*
 * Progammer: Conall Lorentz
 * Dates:
*/
import becker.robots.*;
import java.lang.reflect.Method;

public class RobotTaskL implements Runnable {
	private City field = null;

	public RobotTaskL(City f) {
        field = f;
    }

	public void run() {
		RacerBot rob = new RobL(field, 0, 0, Direction.EAST, 0);
		Thing randomThing = rob.getRandomThing();
		
		try {
            Class<?> thingClass = randomThing.getClass();
            Method getIntersectionMethod = thingClass.getDeclaredMethod("getIntersection");
            getIntersectionMethod.setAccessible(true);
            Object result = getIntersectionMethod.invoke(randomThing);
            System.out.println("Result from getIntersection: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

		rob.move(30);
	}
}