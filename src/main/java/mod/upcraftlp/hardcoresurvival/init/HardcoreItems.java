package mod.upcraftlp.hardcoresurvival.init;

import java.util.HashMap;
import java.util.Map;

import mod.upcraftlp.hardcoresurvival.items.ItemAcorn;
import mod.upcraftlp.hardcoresurvival.items.ItemFlintAxe;
import mod.upcraftlp.hardcoresurvival.items.ItemFlintHoe;
import mod.upcraftlp.hardcoresurvival.items.ItemFlintPickaxe;
import mod.upcraftlp.hardcoresurvival.items.ItemFlintShovel;
import mod.upcraftlp.hardcoresurvival.items.ItemFlintSword;
import mod.upcraftlp.hardcoresurvival.items.ItemPineCone;
import mod.upcraftlp.hardcoresurvival.items.ItemPineConeCooked;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HardcoreItems {

	public static Map<Item, CreativeTabs> itemMap = new HashMap<Item, CreativeTabs>();
	
	public static Item FLINT_AXE = new ItemFlintAxe();
	public static Item FLINT_HOE = new ItemFlintHoe();
	public static Item FLINT_PICKAXE = new ItemFlintPickaxe();
	public static Item FLINT_SHOVEL = new ItemFlintShovel();
	public static Item FLINT_SWORD = new ItemFlintSword();
	public static Item BRANCH = new Item().setUnlocalizedName("branch").setRegistryName("branch");
	public static Item ACORN = new ItemAcorn();
	public static Item PINE_CONE = new ItemPineCone();
	public static Item PINE_CONE_COOKED = new ItemPineConeCooked();
	
	
	public static void init()
	{
		itemMap.put(FLINT_AXE, CreativeTabs.TOOLS);
		itemMap.put(FLINT_HOE, CreativeTabs.TOOLS);
		itemMap.put(FLINT_PICKAXE, CreativeTabs.TOOLS);
		itemMap.put(FLINT_SHOVEL, CreativeTabs.TOOLS);
		itemMap.put(FLINT_SWORD, CreativeTabs.COMBAT);
		itemMap.put(ACORN, CreativeTabs.FOOD);
		itemMap.put(PINE_CONE, CreativeTabs.FOOD);
		itemMap.put(PINE_CONE_COOKED, CreativeTabs.FOOD);
		itemMap.put(BRANCH, CreativeTabs.MATERIALS);
	}
	
}
