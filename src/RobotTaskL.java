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
		Goals randomThing = rob.getRandomThing();

        rob.moveToIntersection(randomThing.getIntersection());
	}
}