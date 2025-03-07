/*
 * Progammer: Conall Lorentz and Charles Damian
 * Dates: Mar. 3
*/
import becker.robots.*;

public class RobotMain {
	public static void main(String[] args) {
		City field = new City("Track.wld");
		field.showThingCounts(true);

		Thread taskL = new Thread(new RobotTaskL(field));
		Thread taskD = new Thread(new RobotTaskD(field));

		Goals[] goals = new Goals[12];
		goals[0] = new Goals(field, 5, 25);
		goals[1] = new Goals(field, 5, 25);
		goals[2] = new Goals(field, 5, 25);
		goals[3] = new Goals(field, 5, 25);
		goals[4] = new Goals(field, 5, 25);

		goals[5] = new Goals(field, 5, 20);
		goals[6] = new Goals(field, 5, 15);
		goals[7] = new Goals(field, 5, 10);
		goals[8] = new Goals(field, 5, 5);
		goals[9] = new Goals(field, 5, 0);
		goals[10] = new Goals(field, 0, 12);
		goals[11] = new Goals(field, 10, 12);

		taskL.start();
		taskD.start();
	}
}
