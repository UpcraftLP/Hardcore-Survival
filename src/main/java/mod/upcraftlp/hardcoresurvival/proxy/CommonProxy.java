package mod.upcraftlp.hardcoresurvival.proxy;

import mod.upcraftlp.hardcoresurvival.init.HardCoreMisc;
import mod.upcraftlp.hardcoresurvival.init.HardcoreBlocks;
import mod.upcraftlp.hardcoresurvival.init.HardcoreConfig;
import mod.upcraftlp.hardcoresurvival.init.HardcoreCrafting;
import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import mod.upcraftlp.hardcoresurvival.util.FuelHandler;
import mod.upcraftlp.hardcoresurvival.util.LeafEvents;
import mod.upcraftlp.hardcoresurvival.util.ModUpdate;
import mod.upcraftlp.hardcoresurvival.util.UpdateEvent;
import mod.upcraftlp.hardcoresurvival.util.WoodEvents;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
		HardcoreConfig.init(event);
		ModUpdate.init();
		HardcoreBlocks.init();
		HardcoreItems.init();
		HardCoreMisc.init();
	}
	
	public void init(FMLInitializationEvent event)
	{
		LeafEvents.init();
		WoodEvents.init();
		UpdateEvent.init();
		HardcoreCrafting.init();
		HardcoreCrafting.registerOres();
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		HardcoreCrafting.disableWoodTools();
	}
}
