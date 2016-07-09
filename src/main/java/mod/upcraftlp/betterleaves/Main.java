package mod.upcraftlp.betterleaves;

import com.mojang.realmsclient.gui.ChatFormatting;

import mod.upcraftlp.betterleaves.proxy.CommonProxy;
import mod.upcraftlp.betterleaves.util.SysUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Reference.NAME, version = Reference.VERSION, modid = Reference.MOD_ID)
public class Main {
	
	@Instance(Reference.MOD_ID)
	private Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PATH, serverSide = Reference.SERVER_PATH)
	public static CommonProxy proxy;
	
	public Main getInstance()
	{
		return this.instance;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//mcmod.info
		ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		data.url = Reference.MOD_URL;
		data.name = ChatFormatting.AQUA + Reference.MOD_ID;
		data.credits = "UpcraftLP";
		data.authorList.add("UpcraftLP");
		//TODO 
		//data.authorList.add("texturer");
		data.modId = Reference.MOD_ID;
		data.version = Reference.VERSION;
		data.description = "Better Leaves Mod";
		//TODO (maybe)
		//data.logoFile = "assets/" + Reference.MOD_ID + "/textures/gui/logo.png";
		
		proxy.preInit(event);
		SysUtils.println("Pre-Initialization finished.");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		SysUtils.println("Initialization finished.");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		SysUtils.println("Post-Initialization finished.");
	}
	
}
