package mod.upcraftlp.hardcoresurvival;

import mod.upcraftlp.hardcoresurvival.init.ModConfig;
import mod.upcraftlp.hardcoresurvival.proxy.CommonProxy;
import mod.upcraftlp.hardcoresurvival.util.ModUpdate;
import mod.upcraftlp.hardcoresurvival.util.SysUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Reference.MODNAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MCVERSION, modid = Reference.MOD_ID, acceptableRemoteVersions = "*", canBeDeactivated = false)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PATH, serverSide = Reference.SERVER_PATH)
	public static CommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		SysUtils.printFML("Pre-Initialization finished.");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		SysUtils.printFML("Initialization finished.");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		SysUtils.printFML("Post-Initialization finished.");
		if(ModConfig.enableUpdateChecker && ModUpdate.isNewVersionAvailable()) {
			SysUtils.printFML("New Version available: " + ModUpdate.getLatest());
			SysUtils.printFML("download it here: " + Reference.UPDATE_URL);
		}
	}
	
	
}
