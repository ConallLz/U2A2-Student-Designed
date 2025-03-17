  /*
 * Progammer: Conall Lorentz
 * Dates: Mar. 3-17
*/
import becker.robots.*;

public class RobotTaskL implements Runnable {
	private City field = null;

	public RobotTaskL(City f) {
        field = f;
    }

	public void run() {
		RacerBot rob = new RobL(field, 0, 0, Direction.EAST, 0);
		rob.turnRight();
		rob.move(5);
		rob.pickThing();
		rob.move(1);
		rob.turnLeft();
		rob.move(6);
		rob.turnLeft();
		rob.move(1);
		rob.turnLeft();
		rob.move(1);
		rob.pickThing();
		rob.turnAround();
		rob.move(4);
		rob.turnLeft();
		rob.move(4);
		rob.turnRight();
		rob.move(11);
		rob.turnLeft();
		rob.move(1);
		rob.turnRight();
		rob.move(5);
		rob.turnRight();
		rob.move(5);
		rob.pickAllThings();
	}
}