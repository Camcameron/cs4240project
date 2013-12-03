package RobotMod.actions;

import RobotMod.EntityRobot;
import net.minecraft.entity.ai.EntityAILookIdle;

public class IdleAction implements EntityAction {
	
	public void performAction(EntityRobot robot) {
		
		robot.tasks.addTask(1, new EntityAILookIdle(robot));		
	}

	@Override
	public void removeAction(EntityRobot robot) {
		robot.tasks.removeTask(new EntityAILookIdle(robot));
		
	}

	
}
