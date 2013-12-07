package RobotMod.actions;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWander;
import RobotMod.EntityRobot;

public class JumpAction implements EntityAction {
	static private boolean enacted = false;

	public void performAction(EntityLiving robot) {
		robot.setFire(8);
	}

	@Override
	public void removeAction(EntityLiving robot) {
		robot.extinguish();
	}

}