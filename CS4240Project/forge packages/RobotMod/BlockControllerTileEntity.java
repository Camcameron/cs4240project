package RobotMod;

import java.util.List;
import java.util.Set;

import RobotMod.actions.AttackAction;
import RobotMod.actions.EntityAction;
import RobotMod.actions.IdleAction;
import RobotMod.actions.JumpAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockControllerTileEntity extends TileEntity {
	private int field_82350_j = 6;
    private int field_82349_r = 16;
    private int field_82348_s = 4;
    private List<Controllable> controllableList;
    private ControllerState state;
    
    public BlockControllerTileEntity()
    {
    	this.setState(IdleState);
        //this.delay = 20; also check out pressure plates?
    }
    
	public List<Controllable> robotsInRange()
    {
		double d0 = 8.0D;
        double d1 = 5.0D;        
        List list = this.worldObj.getEntitiesWithinAABB(Controllable.class, AxisAlignedBB.getAABBPool().getAABB((double)this.xCoord - d0, (double)this.yCoord - d1, (double)this.zCoord - d0, (double)this.xCoord + d0, (double)this.yCoord + d1, (double)this.zCoord + d0));
        //list.get(1).        
		return list;
    }	
	
	public void collectControllables() {
	}
	
	public void issueControlSignal() {
		if(this.state == IdleState){
			this.setState(AttackState);
			System.out.println("Set Attack State!");
		}
		else if(this.state == AttackState){
			this.setState(JumpState);
			System.out.println("Set Jump State!");
		}
		else if(this.state == JumpState){
			this.setState(IdleState);
			System.out.println("Set Idle State!");
		}
		this.state.issueControlSignal(this.worldObj);
		
	}
	public void updateEntity()
	{

		super.updateEntity();

    }
	
	protected void setState(ControllerState state) {
	    //assert state!=null;
	    assert !state.equals(this.state) : "Setting the same state!";
	    
	    this.state = state;
	    
	  }
	private final ControllerState IdleState = new ControllerState(){

		@Override
		public void issueControlSignal(World worldObj) {
			int i = 0;				
			controllableList = robotsInRange();		
			
			for(i = 0; i < controllableList.size(); i++){
				controllableList.get(i).changeBehavior(new IdleAction());
				worldObj.updateEntity((Entity) controllableList.get(i));
			}
			System.out.println("Updated actions...");
		}
		
	};
	
	private final ControllerState AttackState = new ControllerState(){

		@Override
		public void issueControlSignal(World worldObj) {
			int i = 0;				
			controllableList = robotsInRange();		
			
			for(i = 0; i < controllableList.size(); i++){
				controllableList.get(i).changeBehavior(new AttackAction());
				worldObj.updateEntity((Entity) controllableList.get(i));
			}
			System.out.println("Updated actions...");
		}		
	};
	
	private final ControllerState JumpState = new ControllerState(){

		@Override
		public void issueControlSignal(World worldObj) {
			int i = 0;				
			controllableList = robotsInRange();		
			
			for(i = 0; i < controllableList.size(); i++){
				controllableList.get(i).changeBehavior(new JumpAction());
				worldObj.updateEntity((Entity) controllableList.get(i));
			}
			//setState(IdleState);
		}		
	};
	

	
}
