/*
 * Progammer: Charles Damian
 * Dates:
*/
import becker.robots.*;

public class RobotTaskD implements Runnable {
	private City field = null;

	public RobotTaskD(City f) {
        field = f;
    }

	public void run() {
		RacerBot rob = new RobD(field, 0, 10, Direction.EAST, 0);
		Goals randomThing = rob.getRandomThing();

        rob.moveToIntersection(randomThing.getIntersection());

	}
}