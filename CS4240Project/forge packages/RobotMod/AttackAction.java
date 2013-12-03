package RobotMod;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;

public class AttackAction implements EntityAction {

	@Override
	public void performAction(EntityLiving entity) {		
		entity.tasks.addTask(2, new EntityAIAttackOnCollide((EntityCreature) entity, EntityPlayer.class, 1.0D, false));
	}

}
