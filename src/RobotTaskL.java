  /*
 * Progammer: Conall Lorentz
 * Dates:
*/
import becker.robots.*;

public class RobotTaskL implements Runnable {
	private City field = null;

	public RobotTaskL(City f) {
        field = f;
    }

	public void run() {
		RacerBot rob = new RobL(field, 0, 0, Direction.EAST, 0);
		rob.move(12);
		rob.pickThing();
		rob.turnAround();
		rob.move(2);
		rob.turnLeft();
		rob.move(5);
		rob.pickThing();
		rob.move(4);
		rob.turnLeft();
		rob.move(10);
		rob.turnRight();
		rob.move(1);
		rob.turnLeft();
		rob.move(5);
		rob.turnLeft();
		rob.move(5);
		rob.pickAllThings();
	}
}