package mod.upcraftlp.hardcoresurvival.proxy;

import core.upcraftlp.craftdev.API.common.ModRegistry;
import core.upcraftlp.craftdev.API.common.WorldHandler;
import mod.upcraftlp.hardcoresurvival.events.FuelHandler;
import mod.upcraftlp.hardcoresurvival.init.HardcoreBlocks;
import mod.upcraftlp.hardcoresurvival.init.HardcoreCrafting;
import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import mod.upcraftlp.hardcoresurvival.init.ModConfig;
import mod.upcraftlp.hardcoresurvival.world.ChunkGenQuicksand;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
		ModConfig.init(event);
		HardcoreBlocks.init();
		HardcoreItems.init();
		ModRegistry.registerItems(HardcoreItems.itemMap);
		ModRegistry.registerBlocks(HardcoreBlocks.blockMap);
		if(ModConfig.enableQuicksand) WorldHandler.registerChunkGenerator(new ChunkGenQuicksand(), 0);
	}
	
	public void init(FMLInitializationEvent event)
	{
		HardcoreCrafting.init();
		HardcoreCrafting.registerOres();
		GameRegistry.registerFuelHandler(new FuelHandler());
		FuelHandler.registerFuel(HardcoreItems.BRANCH, 100);
		FuelHandler.registerFuel(HardcoreItems.PINE_CONE, 80);
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		HardcoreCrafting.disableWoodTools();
	}
}
