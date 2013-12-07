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

public class EntityRobot extends EntityMob implements Controllable

{
	EntityAction action;
	boolean removeLater;

	public EntityRobot(World par1World) {
		super(par1World);
		removeLater = true;
		this.experienceValue = 20;
		this.action = new IdleAction();

	}

	public void changeBehavior(EntityAction action) {
		this.action.removeAction(this);
		this.action = action;
		this.action.performAction(this);

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setAttribute(2.0D);
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	public int func_110143_aJ() {
		return 10;
	}

	public int func_82193_c(Entity par1Entity) {
		return 4;
	}

	protected void fall(float par1) {
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}

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

	protected boolean isAIEnabled() {
		return true;
	}

}