package mod.upcraftlp.hardcoresurvival.proxy;

import java.util.Arrays;

import core.upcraftlp.craftdev.API.common.ModRegistry;
import mod.upcraftlp.hardcoresurvival.Reference;
import mod.upcraftlp.hardcoresurvival.init.HardcoreBlocks;
import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModRegistry.registerItemRenders(HardcoreItems.itemMap);
		ModRegistry.registerBlockRenders(HardcoreBlocks.blockMap);
		
		/**mcmod.info**/
		ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		data.authorList = Arrays.asList(Reference.authors);
		data.credits = Reference.CREDITS;
		data.description = Reference.MOD_DESCRIPTION;
		data.modId = Reference.MOD_ID;
		data.name = TextFormatting.AQUA + Reference.MODNAME;
		data.updateJSON = Reference.UPDATE_JSON;
		data.url = Reference.MOD_URL;
		data.version = Reference.VERSION;
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
