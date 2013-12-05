package RobotMod;

import javax.imageio.spi.RegisterableService;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "RobotMod", name = "RobotMod", version = "0.0.0")
@NetworkMod(clientSideRequired = true)
public class RobotMod {

	public static int startEntityId = 300;
	public static Block controller;

	// The instance of your mod that Forge uses.
	@Instance(value = "RobotMod")
	public static RobotMod instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "RobotMod.client.ClientProxy", serverSide = "RobotMod.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	// used in 1.6.2
	// @PreInit // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) {

		controller = new BlockController(500, Material.ground)
				.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
				.setUnlocalizedName("Controller")
				.setCreativeTab(CreativeTabs.tabBlock)
				.setTextureName("robotmod:ControllerTexture");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		int id = 0;

		// EntityRegistry.registerModEntity(EntityRobot.class, "Robot", id,
		// this, 80, 1, true);// id is an internal mob id, you can start at

		/*
		 * // 0 and continue adding them up. id++;
		 * EntityRegistry.addSpawn(EntityRobot.class, 2, 0, 1,
		 * EnumCreatureType.creature, BiomeGenBase.biomeList);// change the //
		 * values to // vary the // spawn // rarity, // biome, // etc.
		 */

		// proxy.registerRenderers();// calls the methods in our proxy, which
		// will
		// do things on client side

		LanguageRegistry.instance().addStringLocalization("entity.Robot.name",
				"en_US", "Robot");// set a more
									// readable
									// name for
									// the
									// entity in
									// given
									// language
	}

	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId++;
	}

	public static void registerEntityEgg(Class<? extends Entity> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}

	@EventHandler
	// used in 1.6.2 //@Init // used in 1.5.2
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();

		// EntityRegistry.registerGlobalEntityID(EntityRobot.class, "Robot", 1);
		EntityRegistry.addSpawn(EntityRobot.class, 10, 2, 4,
				EnumCreatureType.creature);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityRobot.class, 0xffffff, 0x000000);
		// RenderingRegistry.registerEntityRenderingHandler(entityRobot.class,
		// new RenederRobot(new ,.5f) renderer);
		
		LanguageRegistry.instance().addStringLocalization("block.Controller.name", "en_US",  "Controller");
        MinecraftForge.setBlockHarvestLevel(controller, "shovel", 0);
        GameRegistry.registerBlock(controller, "Controller");
	}

	@EventHandler
	// used in 1.6.2
	// @PostInit // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
