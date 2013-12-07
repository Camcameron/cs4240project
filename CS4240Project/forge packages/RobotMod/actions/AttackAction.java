package RobotMod.actions;

import RobotMod.EntityRobot;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;

public class AttackAction implements EntityAction {

	private EntityAISwimming test;
	private EntityAIBreakDoor test2;
	private EntityAIAttackOnCollide test3;
	private EntityAIAttackOnCollide test4;
	private EntityAIMoveTowardsRestriction test5;
	private EntityAIMoveThroughVillage test6;
	private EntityAIWander test7;
	private EntityAIWatchClosest test8;
	private EntityAILookIdle test9;
	private EntityAIHurtByTarget test10;
	private EntityAINearestAttackableTarget test11;
	private EntityAINearestAttackableTarget test12;

	@Override
	public void performAction(EntityLiving robot) {

		test = new EntityAISwimming(robot);
		test2 = new EntityAIBreakDoor(robot);
		test3 = new EntityAIAttackOnCollide((EntityCreature) robot,
				EntityPlayer.class, 1.0D, false);
		test4 = new EntityAIAttackOnCollide((EntityCreature) robot,
				EntityVillager.class, 1.0D, true);
		test5 = new EntityAIMoveTowardsRestriction((EntityCreature) robot, 1.0D);
		test6 = new EntityAIMoveThroughVillage((EntityCreature) robot, 1.0D,
				false);
		test7 = new EntityAIWander((EntityCreature) robot, 1.0D);
		test8 = new EntityAIWatchClosest(robot, EntityPlayer.class, 8.0F);
		test9 = new EntityAILookIdle(robot);
		test10 = new EntityAIHurtByTarget((EntityCreature) robot, true);
		test11 = new EntityAINearestAttackableTarget((EntityCreature) robot,
				EntityPlayer.class, 0, true);
		test12 = new EntityAINearestAttackableTarget((EntityCreature) robot,
				EntityVillager.class, 0, false);

		robot.tasks.addTask(0, test);
		robot.tasks.addTask(1, test2);
		robot.tasks.addTask(2, test3);
		robot.tasks.addTask(3, test4);
		robot.tasks.addTask(4, test5);
		robot.tasks.addTask(5, test6);
		robot.tasks.addTask(6, test7);
		robot.tasks.addTask(7, test8);
		robot.tasks.addTask(7, test9);
		robot.targetTasks.addTask(1, test10);
		robot.targetTasks.addTask(2, test11);
		robot.targetTasks.addTask(2, test12);
	}

	@Override
	public void removeAction(EntityLiving robot) {
		robot.tasks.removeTask(this.test);
		robot.tasks.removeTask(this.test2);
		robot.tasks.removeTask(test3);
		robot.tasks.removeTask(test4);
		robot.tasks.removeTask(test5);
		robot.tasks.removeTask(test6);
		robot.tasks.removeTask(test7);
		robot.tasks.removeTask(test8);
		robot.tasks.removeTask(test9);
		robot.targetTasks.removeTask(test10);
		robot.targetTasks.removeTask(test11);
		robot.targetTasks.removeTask(test12);
	}

}