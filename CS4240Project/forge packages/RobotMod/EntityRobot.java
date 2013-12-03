package RobotMod;

import javax.swing.text.html.parser.Entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRobot extends EntityMob implements Controllable// extend this to make mob
												// hostile
{
	EntityAction action;
	boolean removeLater;
	
	public EntityRobot(World par1World) {
		super(par1World);
		removeLater = true;
		this.experienceValue = 20;
		//this.tasks.addTask(1, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true)); this.tasks.addTask(0, new EntityAISwimming(this));
        //this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
       // this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
		//this.texture = "";
		//texture is set in RenderRobot.java
		//this.texture = "/mob/RobotTexture.png";

		//
	}

	//The controller block changes state and passes the corresponding EntityAction to the robot
	public void updateBehavior(EntityAction action) {
		//Clear existing tasks
		this.tasks.taskEntries.clear();
		this.targetTasks.taskEntries.clear();
		//change action
		this.action = action;

	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
    }
	
	////////////////////
	///Action classes///
	/*
	public class JumpAction implements EntityAction{
		public void performAction(EntityRobot robot) {
			robot.jump();	
		}
		
	}
	*/

	/*
	public void setAction(EntityAction action){
		this.action = action;
	}
	*/
	///             ///
	///////////////////
	
	public void onLivingUpdate() {
//		this.jump();
		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			this.updateBehavior(new AttackAction());
		} else {
			this.updateBehavior(new IdleAction());
		}
//		if(removeLater == true){
//			this.setAction(new AttackAction());
//			removeLater = false;
//		}
//		else{
//			this.setAction(new JumpAction());
//			removeLater = true;
//		}
	this.action.performAction(this);
		super.onLivingUpdate();
	}
	
	//AMount of health
	public int func_110143_aJ () {
		return 10;
	}

	public int func_82193_c(Entity par1Entity) // the amount of damage
	{
		return 4;
	}

	protected void fall(float par1) {
	}


	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}

	//pig sounds are placeholders
	protected String getLivingSound() {
		return "mob.pig.say";
	}

	protected String getHurtSound() {
		return "mob.pig.say";
	}

	protected String getDeathSound() {
		return "mob.pig.death";
	}

	protected int getDropItemId() {
		return Item.stick.itemID;
	}

	protected boolean canDespawn() {
		return true;
	}

	protected boolean isAIEnabled()// Allow your AI task to work?
	{
		return true;
	}
}