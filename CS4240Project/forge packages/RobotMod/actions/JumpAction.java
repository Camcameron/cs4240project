package RobotMod.actions;

import RobotMod.EntityRobot;

public class JumpAction implements EntityAction {
	
	public void performAction(EntityRobot robot) {
		robot.setFire(1);
	}

	@Override
	public void removeAction(EntityRobot robot) {
		robot.extinguish();
		
	}

	
}