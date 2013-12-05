package RobotMod.actions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import RobotMod.EntityRobot;

public interface EntityAction {
	public void performAction(EntityLiving robot);
	public void removeAction(EntityLiving robot);
}
