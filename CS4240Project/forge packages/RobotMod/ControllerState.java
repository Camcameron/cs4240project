package RobotMod;

import net.minecraft.world.World;

public interface ControllerState {
	public void issueControlSignal(World worldObj);
	public void transition(BlockControllerTileEntity te, BlockController b);
}
