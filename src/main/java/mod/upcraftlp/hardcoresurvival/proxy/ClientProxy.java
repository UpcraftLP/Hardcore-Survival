package mod.upcraftlp.hardcoresurvival.proxy;

import mod.upcraftlp.hardcoresurvival.init.HardcoreBlocks;
import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import mod.upcraftlp.hardcoresurvival.util.ModRegistry;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModRegistry.registerModMetaData(event, TextFormatting.AQUA);
		HardcoreItems.registerRenders();
		HardcoreBlocks.registerRenders();
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
	super.postInit(event);	
	}
}
