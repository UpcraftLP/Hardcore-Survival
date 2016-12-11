package mod.upcraftlp.hardcoresurvival.init;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import core.upcraftlp.craftdev.API.common.ModHelper;
import mod.upcraftlp.hardcoresurvival.Reference;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {

	private static final String CATEGORY_GAME_TWEAKS = "Game Tweaks";
	public static Configuration config;
	
	public static int stickChance;
	public static int saplingChance;
	
	public static boolean disableWoodenTools;
	public static boolean enableFlintTools;
	public static boolean enableBranches;
	public static boolean woodRequiresAxe;
	public static boolean extraDrops;
	public static int extraChance;
	public static boolean enableQuicksand;
	
	public static void init(FMLPreInitializationEvent event)
	{
		config = ModHelper.getConfigFile(event, Reference.MODID); 
		config.load();
		syncConfig();
	}
	
public static void syncConfig() {
		
		/** Configuration Start **/
			//General
			stickChance = config.getInt("stickDrops", Configuration.CATEGORY_GENERAL, 5, 1, 16384, "Chance to drop sticks, chance is 1/n leaf blocks");
			saplingChance = config.getInt("saplingDrops", Configuration.CATEGORY_GENERAL, 7, 1, 16384, "Chance to drop saplings, chance is 1/n leaf blocks");
			extraChance = config.getInt("extraDropChance", Configuration.CATEGORY_GENERAL, 5, 1, 16384, "chance to get extra drops, chance is 1/n leaf blocks");
			
			//Game Tweaks
			disableWoodenTools = config.getBoolean("disableWoodenTools", ModConfig.CATEGORY_GAME_TWEAKS, true, "disable crafting of vanilla wooden tools");
			enableFlintTools = config.getBoolean("enableFintTools", ModConfig.CATEGORY_GAME_TWEAKS, true, "enable mod flint tools, same stats as wooden tools");
			enableBranches = config.getBoolean("enableBranches", ModConfig.CATEGORY_GAME_TWEAKS, true, "add branches to drop from leaves instead of sticks (they just can be used as sticks)");
			woodRequiresAxe = config.getBoolean("woodRequiresAxe", ModConfig.CATEGORY_GAME_TWEAKS, true, "make wood blocks require an Axe");
			extraDrops = config.getBoolean("enableExtraDrops", ModConfig.CATEGORY_GAME_TWEAKS, true, "enable/disable extra drops (acorns, pine cones, cocoa beans, etc.) from leaves");
			enableQuicksand = config.getBoolean("enableQuicksand", ModConfig.CATEGORY_GAME_TWEAKS, false, "enable/disable quicksand [WIP]"); //TODO: set to true when finished!
		/** Configuration End **/
		
		config.setCategoryRequiresMcRestart(CATEGORY_GAME_TWEAKS, true);
		if(config.hasChanged()) config.save();
	}

	public static boolean isDebugMode() {
		return ModHelper.isDebugMode();
	}

	public static List<IConfigElement> getEntries() {
		List<IConfigElement> entries = new ArrayList<IConfigElement>();
		Set<String> categories = config.getCategoryNames();
		Iterator<String> i = categories.iterator();
		while(i.hasNext()) {
			String categoryName = i.next();
			ConfigCategory category = config.getCategory(categoryName);
			entries.addAll(new ConfigElement(category).getChildElements());
		}
		return entries;
	}

	@SubscribeEvent
	public static void configChanged(OnConfigChangedEvent event) {
		if(event.getModID().equals(Reference.MODID)) {
			syncConfig();
		}
}
	
	
}
