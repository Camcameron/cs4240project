package net.minecraft.src;

public class RenderRobot extends RenderLiving {

	//RobotTexture.png is dragged into this location in the 1.6.2 jar file using 7zip
	 private static final ResourceLocation Texture = new ResourceLocation(
			 "Robot","/textures/entity/RobotTexture.png");
	 
	public RenderRobot(ModelBase modelBase, float par2) {
		super(modelBase, par2);
	}

	public void func_177_a(EntityRobot robot, double d, double d1, double d2,
			float f, float f1) {
		super.doRenderLiving(robot, d, d1, d2, f, f1);
	}

	public void doRenderLiving( EntityLiving entity, double d, double d1, double d2, float f, float f1 ) {
		func_177_a((EntityRobot) entity, d, d1, d2, f, f1 );
	}

	@Override
	protected ResourceLocation func_110775_a(Entity var1) {
		// TODO Auto-generated method stub
		return this.Texture;
	}
	

}
