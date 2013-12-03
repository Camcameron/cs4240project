package RobotMod;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookAtVillager;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;

public class AttackAction implements EntityAction {

	@Override
	public void performAction(EntityLiving entity) {		
		entity.tasks.addTask(1, new EntityAIAttackOnCollide((EntityCreature) entity, 1.0D, true));
        entity.tasks.addTask(2, new EntityAIMoveTowardsTarget((EntityCreature) entity, 0.9D, 32.0F));
        entity.tasks.addTask(3, new EntityAIMoveThroughVillage((EntityCreature) entity, 0.6D, true));
        entity.tasks.addTask(4, new EntityAIMoveTowardsRestriction((EntityCreature) entity, 1.0D));               
        
        entity.tasks.addTask(6, new EntityAIWander((EntityCreature) entity, 0.6D));
        entity.tasks.addTask(7, new EntityAIWatchClosest(entity, EntityPlayer.class, 6.0F));
        entity.tasks.addTask(8, new EntityAILookIdle(entity));
        
        entity.targetTasks.addTask(2, new EntityAIHurtByTarget((EntityCreature) entity, false));
        entity.targetTasks.addTask(3, new EntityAINearestAttackableTarget((EntityCreature) entity, EntityLiving.class, 0, false, true, IMob.mobSelector));
        
	}

}
