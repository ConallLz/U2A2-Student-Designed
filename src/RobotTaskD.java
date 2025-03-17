/*
 * Progammer: Charles Damian
 * Dates: Mar. 3-17
*/
import becker.robots.*;

// Implements runnable so it can be run as a thread
public class RobotTaskD implements Runnable {
	private City field = null;

	/**
	 * @param f - City where robot in the thread should be
	 */
	public RobotTaskD(City f) {
		// Set city when the thread runs to what was given
        field = f;
    }

	public void run() {
		RacerBot rob = new RobD(field, 0, 10, Direction.EAST, 0);
		rob.move(12);
		rob.pickThing();
		rob.turnAround();
		rob.move(2);
		rob.turnRight();
		rob.move(5);
		rob.pickThing();
		rob.move(4);
		rob.turnRight();
		rob.move(10);
		rob.turnLeft();
		rob.move(1);
		rob.turnRight();
		rob.move(1);
		rob.moveToIntersection(new Intersection(field, 5, 25));
		rob.pickAllThings();
	}
}