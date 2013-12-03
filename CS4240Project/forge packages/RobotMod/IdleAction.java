package RobotMod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;

public class IdleAction implements EntityAction {

	@Override
	public void performAction(EntityLiving entity) {		
		entity.tasks.addTask(1, new EntityAILookIdle(entity));		
	}

	
}
