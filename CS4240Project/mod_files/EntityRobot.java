package net.minecraft.src;

public class EntityRobot extends EntityCreature {
	public EntityRobot(World par1World) {
		super(par1World);
	}

	public int func_82193_c(Entity par1Entity) {
		return 4;
	}

	protected void fall(float par1) {
	}

	public int getMaxHealth() {
		return 10;
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