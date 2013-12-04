package RobotMod;

import java.util.List;

import RobotMod.actions.AttackAction;
import RobotMod.actions.JumpAction;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class BlockControllerTileEntity extends TileEntity {
	private int field_82350_j = 6;
    private int field_82349_r = 16;
    private int field_82348_s = 4;
    
    public BlockControllerTileEntity()
    {
        //this.delay = 20; also check out pressure plates?
    }
    
	public List robotsInRange()
    {
		double d0 = 8.0D;
        double d1 = 5.0D;
        List list = this.worldObj.getEntitiesWithinAABB(EntityRobot.class, AxisAlignedBB.getAABBPool().getAABB((double)this.xCoord - d0, (double)this.yCoord - d1, (double)this.zCoord - d0, (double)this.xCoord + d0, (double)this.yCoord + d1, (double)this.zCoord + d0));
        //list.get(1).
		return list;
    }	
	
	public void updateEntity()
	{
		int i = 0;
		List list = robotsInRange();
		for(i = 0; i < list.size(); i++){
			System.out.println("!wwwwwwwwwww!");
			System.out.println(list.get(i));
			//((EntityRobot) list.get(i)).changeBehavior(new JumpAction());
			((EntityRobot) list.get(i)).setJumping(true);
			System.out.println("!wwwwwwwwwww!");
			
		}
		super.updateEntity();
		//v might be usefull for getting robots?
		//EntityRobot robot = null;
		//this.worldObj.getEntitiesWithinAABB(robot, par2AxisAlignedBB);
		//int i;
		//this.worldObj.getEntitiesWithinAABB(robot.getClass(), par2AxisAlignedBB);
		//this.worldObj.createExplosion(this, (double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, (double)this.field_82349_r);
    }
	
	public void load(){
		ModLoader.registerTileEntity(BlockControllerTileEntity.class, "BlockController");	
	}
	
}
