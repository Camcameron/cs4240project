package RobotMod;

import java.util.List;
import java.util.Random;

import RobotMod.actions.AttackAction;
import RobotMod.actions.JumpAction;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockController extends BlockContainer {
	private boolean sensible;
	private BlockControllerTileEntity tileEntity;
	private ControllerState state;
	
	
	public BlockController(int par1, Material par2Material) {
		super(par1, par2Material);
		sensible = true;
		tileEntity = null;
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {	
		super.onBlockAdded(par1World, par2, par3, par4);
	}
	
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
   
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World)
    {
        return this.sensible ? 30 : 20;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        this.func_82534_e(l);
    }

    private void func_82534_e(int par1)
    {
        int j = par1 & 7;
        boolean flag = (par1 & 8) > 0;
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.1875F;
        float f3 = 0.125F;

        if (flag)
        {
            f3 = 0.0625F;
        }

        if (j == 1)
        {
            this.setBlockBounds(0.0F, f, 0.5F - f2, f3, f1, 0.5F + f2);
        }
        else if (j == 2)
        {
            this.setBlockBounds(1.0F - f3, f, 0.5F - f2, 1.0F, f1, 0.5F + f2);
        }
        else if (j == 3)
        {
            this.setBlockBounds(0.5F - f2, f, 0.0F, 0.5F + f2, f1, f3);
        }
        else if (j == 4)
        {
            this.setBlockBounds(0.5F - f2, f, 1.0F - f3, 0.5F + f2, f1, 1.0F);
        }
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	
    	par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, 0.6F);
        this.setLightValue(20);
        tileEntity.issueControlSignal();
//        int i1 = par1World.getBlockMetadata(par2, par3, par4);
//        int j1 = i1 & 7;
//        int k1 = 8 - (i1 & 8);
    		
//        if (k1 == 0)
//        {
//            return true;
//        }
//        else
//        {
            //par1World.setBlockMetadataWithNotify(par2, par3, par4, j1 + k1, 3);
            //par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            
            
//            List list = this.tileEntity.robotsInRange();
//    		int i = 0;
    		//this.tileEntity.changeState();
    		
            //this.func_82536_d(par1World, par2, par3, par4, j1);
            //par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
            return true;
        }
    

    /**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if ((par6 & 8) > 0)
        {
            int j1 = par6 & 7;
            this.func_82536_d(par1World, par2, par3, par4, j1);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    
    public boolean canProvidePower()
    {
        return true;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if ((l & 8) != 0)
            {
                if (this.sensible)
                {
                    this.func_82535_o(par1World, par2, par3, par4);
                }
                else
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l & 7, 3);
                    int i1 = l & 7;
                    this.func_82536_d(par1World, par2, par3, par4, i1);
                    par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, 0.5F);
                    par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
                }
            }
        }
    }

//    /**
//     * Sets the block's bounds for rendering it as an item
//     */
//    public void setBlockBoundsForItemRender()
//    {
//        float f = 0.1875F;
//        float f1 = 0.125F;
//        float f2 = 0.125F;
//        this.setBlockBounds(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
//    }

    

    protected void func_82535_o(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i1 = l & 7;
        boolean flag = (l & 8) != 0;
        this.func_82534_e(l);
        List list = par1World.getEntitiesWithinAABB(EntityArrow.class, AxisAlignedBB.getAABBPool().getAABB((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)par3 + this.maxY, (double)par4 + this.maxZ));
        boolean flag1 = !list.isEmpty();

        if (flag1 && !flag)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 | 8, 3);
            this.func_82536_d(par1World, par2, par3, par4, i1);
            par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!flag1 && flag)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i1, 3);
            this.func_82536_d(par1World, par2, par3, par4, i1);
            par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (flag1)
        {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
        }
    }

    private void func_82536_d(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);

        if (par5 == 1)
        {
            par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
        }
        else if (par5 == 2)
        {
            par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
        }
        else if (par5 == 3)
        {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
        }
        else if (par5 == 4)
        {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
        }
        else
        {
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
        }
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		
		tileEntity = new BlockControllerTileEntity();
		return tileEntity;
	}

}
