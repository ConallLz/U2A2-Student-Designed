/*
 * Progammer: Conall Lorentz and Charles Damian
 * Dates: Mar. 3
*/
import becker.robots.City;

public class RobotMain {
	public static void main(String[] args) {
		City field = new City("Track.wld");
		field.showThingCounts(true);

		Thread taskL = new Thread(new RobotTaskL(field));
		Thread taskD = new Thread(new RobotTaskD(field));

		taskL.start();
		taskD.start();
	}
}
