package RobotMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import RobotMod.CommonProxy;
import RobotMod.EntityRobot;
import RobotMod.ModelRobot;
import RobotMod.RenderRobot;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderers() {        	
                // This is for rendering entities and so forth later on
        	RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderRobot(new ModelRobot(), .5f));
        	EntityRegistry.registerGlobalEntityID(EntityRobot.class, "Robot", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
        }
        
}
