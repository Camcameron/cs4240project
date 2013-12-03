package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GenericBlock extends Block {

	public GenericBlock(int id, Material material) {
		super(id, material);
	}

	public final static Block genericDirt = new GenericBlock(500,
			Material.ground).setHardness(0.5F)
			.setStepSound(Block.soundGravelFootstep)
			.setUnlocalizedName("genericDirt")
			.setCreativeTab(CreativeTabs.tabBlock);

	public void load() {
		GameRegistry.registerBlock(genericDirt, "genericDirt");
		LanguageRegistry.addName(genericDirt, "Generic Dirt");
	}
}
