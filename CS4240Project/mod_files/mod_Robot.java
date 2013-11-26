package net.minecraft.src;

import java.awt.Color;
import java.util.Map;

public class mod_Robot extends BaseMod {


	
	public void addRenderer(Map map) {
		map.put(EntityRobot.class, new RenderRobot(new ModelRobot(), .5f));	
	}
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "CS4240 Robot mod";
	}

	@Override
	public void load() {
		ModLoader.registerEntityID(EntityRobot.class, "Robot", 100);//registers the mobs name and id
		ModLoader.addSpawn("Robot", 15, -5, 1, EnumCreatureType.creature);//makes the mob spawn in game
		ModLoader.addLocalization("entity.Robot.name", "Robot");//adds Mob name on the spawn egg
		//creates the spawn egg, and changes color of egg
		EntityList.entityEggs.put(Integer.valueOf(70), new EntityEggInfo(70, 894731, (new Color(21, 15, 6)).getRGB()));
		
	}

}
