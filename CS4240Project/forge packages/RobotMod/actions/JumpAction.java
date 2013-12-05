package RobotMod.actions;

import net.minecraft.entity.EntityLiving;
import RobotMod.EntityRobot;

public class JumpAction implements EntityAction {
	
	public void performAction(EntityLiving robot) {
		//Adds the tasks.
		//If you add a new task, please add a corresponding remove function in removeAction
		//Note: This isn't a task so does not need to be removed but something that ends it is helpful too
		robot.setFire(1);
	}

	@Override
	public void removeAction(EntityLiving robot) {
		robot.extinguish();
		
	}

	
}