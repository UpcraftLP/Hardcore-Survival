package mod.upcraftlp.hardcoresurvival.proxy;

import mod.upcraftlp.hardcoresurvival.init.LeafConfig;
import mod.upcraftlp.hardcoresurvival.init.LeafCrafting;
import mod.upcraftlp.hardcoresurvival.init.LeafItems;
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
		LeafConfig.init(event);
		ModUpdate.init();
		LeafItems.init();
	}
	
	public void init(FMLInitializationEvent event)
	{
		LeafEvents.init();
		WoodEvents.init();
		UpdateEvent.init();
		LeafCrafting.init();
		LeafCrafting.registerOres();
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		LeafCrafting.disableWoodTools();
	}
}
