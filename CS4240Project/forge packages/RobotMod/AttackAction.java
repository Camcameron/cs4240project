package RobotMod;

public class AttackAction implements EntityAction {

	public void performAction(EntityRobot robot) {
		robot.setFire(1);	
	}

}
