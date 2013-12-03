package RobotMod.actions;

import RobotMod.EntityRobot;

public interface EntityAction {
	
	public void performAction(EntityRobot robot);
	public void removeAction(EntityRobot robot);
}
