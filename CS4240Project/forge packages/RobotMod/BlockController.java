package RobotMod;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockController extends Block {

	public BlockController(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {	
		super.onBlockAdded(par1World, par2, par3, par4);
	}

}
