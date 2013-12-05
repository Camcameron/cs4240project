package RobotMod.actions;

import RobotMod.EntityRobot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;

public class IdleAction implements EntityAction {
	
	public void performAction(EntityLiving robot) {
		//Adds the tasks.
		//If you add a new task, please add a corresponding remove function in removeAction
		robot.tasks.addTask(1, new EntityAILookIdle(robot));		
	}

	@Override
	public void removeAction(EntityLiving robot) {
		robot.tasks.taskEntries.clear();
		robot.targetTasks.taskEntries.clear();
		//robot.tasks.removeTask(new EntityAILookIdle(robot));
		
	}

	
}
