package mod.upcraftlp.betterleaves.init;


import mod.upcraftlp.betterleaves.items.ItemFlintAxe;
import mod.upcraftlp.betterleaves.items.ItemFlintHoe;
import mod.upcraftlp.betterleaves.items.ItemFlintPickaxe;
import mod.upcraftlp.betterleaves.items.ItemFlintShovel;
import mod.upcraftlp.betterleaves.items.ItemFlintSword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeafItems {

	public static Item FLINT_AXE = new ItemFlintAxe();
	public static Item FLINT_HOE = new ItemFlintHoe();
	public static Item FLINT_PICKAXE = new ItemFlintPickaxe();
	public static Item FLINT_SHOVEL = new ItemFlintShovel();
	public static Item FLINT_SWORD = new ItemFlintSword();
	public static Item BRANCH = new Item().setUnlocalizedName("branch").setRegistryName("branch").setCreativeTab(CreativeTabs.MATERIALS);
	
	public static void init()
	{
		if(LeafConfig.enableFlintTools)
		{
			register(FLINT_AXE);
			register(FLINT_HOE);
			register(FLINT_PICKAXE);
			register(FLINT_SHOVEL);
			register(FLINT_SWORD);
		}
		
		if(LeafConfig.enableBranches) register(BRANCH);
	}
	
	public static void register(Item item)
	{
		GameRegistry.register(item);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		if(LeafConfig.enableBranches) registerRender(BRANCH);
		if(LeafConfig.enableFlintTools)
		{
			registerRender(FLINT_AXE);
			registerRender(FLINT_HOE);
			registerRender(FLINT_PICKAXE);
			registerRender(FLINT_SHOVEL);
			registerRender(FLINT_SWORD);
		}
		
	}
	
}
