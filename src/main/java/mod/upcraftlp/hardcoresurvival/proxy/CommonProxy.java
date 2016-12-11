package mod.upcraftlp.hardcoresurvival.proxy;

import mod.upcraftlp.hardcoresurvival.events.LeafEvents;
import mod.upcraftlp.hardcoresurvival.events.WoodEvents;
import mod.upcraftlp.hardcoresurvival.init.HardcoreCrafting;
import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import mod.upcraftlp.hardcoresurvival.util.ModRegistry;
import mod.upcraftlp.hardcoresurvival.util.UpdateEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
		ModRegistry.preInit(event);
		HardcoreItems.init();
	}
	
	public void init(FMLInitializationEvent event)
	{
		LeafEvents.init();
		WoodEvents.init();
		UpdateEvent.init();
		HardcoreCrafting.init();
		HardcoreCrafting.registerOres();
		ModRegistry.registerFuel(HardcoreItems.BRANCH, 120);
		ModRegistry.registerFuel(HardcoreItems.PINE_CONE, 80);
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		HardcoreCrafting.disableWoodTools();
	}
}
