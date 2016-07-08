package mod.upcraftlp.betterleaves.proxy;

import mod.upcraftlp.betterleaves.init.LeafConfig;
import mod.upcraftlp.betterleaves.init.LeafCrafting;
import mod.upcraftlp.betterleaves.init.LeafItems;
import mod.upcraftlp.betterleaves.util.LeafEvents;
import mod.upcraftlp.betterleaves.util.ModUpdate;
import mod.upcraftlp.betterleaves.util.UpdateEvent;
import mod.upcraftlp.betterleaves.util.WoodEvents;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		LeafCrafting.disableWoodTools();
	}
}
