package RobotMod.actions;

import RobotMod.EntityRobot;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
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
//	static boolean enacted;
//	
//	public AttackAction(){
//		enacted = false;
//	}
	@Override
	public void performAction(EntityRobot robot) {	
		//if(enacted == false){
		//robot.tasks.taskEntries.clear();
        robot.tasks.addTask(0, new EntityAISwimming(robot));
        robot.tasks.addTask(1, new EntityAIBreakDoor(robot));
        robot.tasks.addTask(2, new EntityAIAttackOnCollide(robot, EntityPlayer.class, 1.0D, false));
        robot.tasks.addTask(3, new EntityAIAttackOnCollide(robot, EntityVillager.class, 1.0D, true));
        robot.tasks.addTask(4, new EntityAIMoveTowardsRestriction(robot, 1.0D));
        robot.tasks.addTask(5, new EntityAIMoveThroughVillage(robot, 1.0D, false));
        robot.tasks.addTask(6, new EntityAIWander(robot, 1.0D));
        robot.tasks.addTask(7, new EntityAIWatchClosest(robot, EntityPlayer.class, 8.0F));
        robot.tasks.addTask(7, new EntityAILookIdle(robot));
        robot.targetTasks.addTask(1, new EntityAIHurtByTarget(robot, true));
        robot.targetTasks.addTask(2, new EntityAINearestAttackableTarget(robot, EntityPlayer.class, 0, true));
        robot.targetTasks.addTask(2, new EntityAINearestAttackableTarget(robot, EntityVillager.class, 0, false));
		//}
	}

	@Override
	public void removeAction(EntityRobot robot) {
//		robot.tasks.taskEntries.clear();
//		robot.targetTasks.taskEntries.clear();
		//int i;
		//for(i = 0; i < robot.tasks.taskEntries.size(); i++){
		robot.tasks.removeTask(new EntityAISwimming(robot));
        robot.tasks.removeTask(new EntityAIBreakDoor(robot));
        robot.tasks.removeTask(new EntityAIAttackOnCollide(robot, EntityPlayer.class, 1.0D, false));
        robot.tasks.removeTask(new EntityAIAttackOnCollide(robot, EntityVillager.class, 1.0D, true));
        robot.tasks.removeTask(new EntityAIMoveTowardsRestriction(robot, 1.0D));
        robot.tasks.removeTask(new EntityAIMoveThroughVillage(robot, 1.0D, false));
        robot.tasks.removeTask(new EntityAIWander(robot, 1.0D));
        robot.tasks.removeTask(new EntityAIWatchClosest(robot, EntityPlayer.class, 8.0F));
        robot.tasks.removeTask(new EntityAILookIdle(robot));
		robot.targetTasks.removeTask(new EntityAIHurtByTarget(robot, true));
	    robot.targetTasks.removeTask(new EntityAINearestAttackableTarget(robot, EntityPlayer.class, 0, true));
	    robot.targetTasks.removeTask(new EntityAINearestAttackableTarget(robot, EntityVillager.class, 0, false));
		
		
	}

}
