package net.minecraft.src;

public class EntityRobot extends EntityCreature// extend this to make mob
												// hostile
{
	public EntityRobot(World par1World) {
		super(par1World);
		
		//texture is set in RenderRobot.java
		//this.texture = "/mob/RobotTexture.png";

		//

	}

	public int func_82193_c(Entity par1Entity) // the amount of damage
	{
		return 4;
	}

	protected void fall(float par1) {
	}

	public int getMaxHealth() // Mob health
	{
		return 10;
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