package RobotMod;

import javax.swing.text.html.parser.Entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRobot extends EntityMob// extend this to make mob
												// hostile
{
	public EntityRobot(World par1World) {
		super(par1World);
		this.experienceValue = 20;
		this.tasks.addTask(1, new EntityAILookIdle(this));
		//this.texture = "";
		//texture is set in RenderRobot.java
		//this.texture = "/mob/RobotTexture.png";

		//

	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
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