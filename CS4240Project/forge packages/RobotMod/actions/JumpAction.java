package RobotMod.actions;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWander;
import RobotMod.EntityRobot;

public class JumpAction implements EntityAction {
	static private boolean enacted = false;
	
	public void performAction(EntityLiving robot) {
		//Adds the tasks.
		//If you add a new task, please add a corresponding remove function in removeAction
		//Note: This isn't a task so does not need to be removed but something that ends it is helpful too
		robot.setFire(1);
		//robot.setDead();
		//robot.tasks.addTask(1, new EntityAIWander((EntityCreature) robot, 1.0D));
		//robot.setSprinting(true);
		//robot.setAIMoveSpeed((float) .5);
		
	}

	@Override
	public void removeAction(EntityLiving robot) {
			robot.setJumping(false);
	}
	
}