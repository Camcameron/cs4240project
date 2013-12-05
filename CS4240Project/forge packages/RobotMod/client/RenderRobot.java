package RobotMod;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderRobot extends RenderBiped {

	//RobotTexture.png is dragged into this location in the 1.6.2 jar file using 7zip
	 private static final ResourceLocation Texture = new ResourceLocation(
			 "RobotMod:textures/RobotTexture.png");
	 
	public RenderRobot(ModelBase modelBase, float par2) {
		super((ModelBiped) modelBase, par2);
	}
	
	public void func_177_a(EntityRobot robot, double d, double d1, double d2,
			float f, float f1) {
		super.doRenderLiving(robot, d, d1, d2, f, f1);
	}
	
	
	public void doRenderLiving(EntityLiving entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving((EntityRobot) entity, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1 ) {
		func_177_a((EntityRobot) entity, d, d1, d2, f, f1 );
	}

	@Override
	protected ResourceLocation getEntityTexture(
			net.minecraft.entity.Entity entity) {
		// TODO Auto-generated method stub
		return Texture;
	}


	

}
