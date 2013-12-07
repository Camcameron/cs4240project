package RobotMod.actions;

import net.minecraft.entity.EntityLiving;
import RobotMod.EntityRobot;

public interface EntityAction {
	public void performAction(EntityLiving Entity);

	public void removeAction(EntityLiving Entity);
}
