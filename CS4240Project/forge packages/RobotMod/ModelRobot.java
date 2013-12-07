package RobotMod;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelRobot extends ModelBiped {
	ModelRenderer head = super.bipedHead;
	ModelRenderer body = super.bipedBody;
	ModelRenderer rightarm = super.bipedRightArm;
	ModelRenderer leftarm = super.bipedLeftArm;
	ModelRenderer rightleg = super.bipedRightLeg;
	ModelRenderer leftleg = super.bipedLeftLeg;
	ModelRenderer Antenna;
	ModelRenderer AntennaTop;

	public ModelRobot() {
		textureWidth = 64;
		textureHeight = 32;
		head.addBox(-4F, -8F, -4F, 8, 8, 8, 1);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);

		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0F, 0F, 0F);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		Antenna = new ModelRenderer(this, 36, 2);
		Antenna.addBox(0F, 0F, 0F, 1, 4, 1);
		Antenna.setRotationPoint(-0.5F, -12F, 0F);
		Antenna.setTextureSize(64, 32);
		Antenna.mirror = true;
		setRotation(Antenna, 0F, 0F, 0F);
		AntennaTop = new ModelRenderer(this, 49, 2);
		AntennaTop.addBox(0F, 0F, 0F, 2, 2, 2);
		AntennaTop.setRotationPoint(-1F, -13F, -0.5F);
		AntennaTop.setTextureSize(64, 32);
		AntennaTop.mirror = true;
		setRotation(AntennaTop, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		Antenna.render(f5);
		AntennaTop.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}
}
