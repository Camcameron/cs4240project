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
import RobotMod.actions.*;
import RobotMod.actions.EntityAction;

public class EntityRobot extends EntityMob implements Controllable// extend this to make mob
												// hostile
{
	EntityAction action;
	boolean removeLater;
	
	public EntityRobot(World par1World) {
		super(par1World);
		removeLater = true;
		this.experienceValue = 20;
		this.action =  new JumpAction();
		//this.action.performAction(this);
		//this.action.removeAction(this);

        
		//texture is set in RenderRobot.java
		//this.texture = "/mob/RobotTexture.png";

		//
	}

	//The controller block changes state and passes the corresponding EntityAction to the robot
	public void changeBehavior(EntityAction action) {
		//Clear existing tasks
		//this.tasks.taskEntries.clear();
		
		this.action.removeAction(this);
		this.action = action;
		this.action.performAction(this);

	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2.0D);
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
		
		if(!this.worldObj.isRemote){
			if (this.worldObj.isDaytime()) {
				//System.out.println("true");
				//this.changeBehavior(new JumpAction());
			} else {
				//System.out.println("false");
				//this.changeBehavior(new AttackAction());
			}
		}
		//this.action = new JumpAction();
		//this.action.performAction(this);
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

	protected boolean isAIEnabled()// .Allow your AI task to work?
	{
		return true;
	}


}