package mod.upcraftlp.hardcoresurvival.init;

import java.util.Iterator;

import mod.upcraftlp.hardcoresurvival.util.SysUtils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class HardcoreCrafting {

	public static void registerOres()
	{
		OreDictionary.registerOre("stick", Items.STICK);
		OreDictionary.registerOre("fluidWater", Items.WATER_BUCKET);
		OreDictionary.registerOre("fluidWater", new ItemStack(Items.POTIONITEM, 1, 0));
		OreDictionary.registerOre("blockSand", Blocks.SAND);
		OreDictionary.registerOre("blockSand", new ItemStack(Blocks.SAND, 1, 1));
		if(ModConfig.enableBranches) OreDictionary.registerOre("stick", HardcoreItems.BRANCH);
	}
	
	public static void init()
	{
		if(ModConfig.enableFlintTools)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HardcoreItems.FLINT_AXE, 1), "FS", " S", 'F', Items.FLINT, 'S', "stick").setMirrored(true));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HardcoreItems.FLINT_HOE, 1), "FF", " S", " S", 'F', Items.FLINT, 'S', "stick").setMirrored(true));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HardcoreItems.FLINT_PICKAXE, 1), "FFF", " S ", " S ", 'F', Items.FLINT, 'S', "stick"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HardcoreItems.FLINT_SHOVEL, 1), "F", "S", "S", 'F', Items.FLINT, 'S', "stick"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HardcoreItems.FLINT_SWORD, 1), "F", "F", "S", 'F', Items.FLINT, 'S', "stick"));
		}
		
		if(ModConfig.extraDrops)
		{
			GameRegistry.addSmelting(new ItemStack(HardcoreItems.PINE_CONE,  1, 0), new ItemStack(HardcoreItems.PINE_CONE, 1, 1), 0.2f);
		}
		
	}
	
	public static void disableWoodTools()
	{
		if(ModConfig.disableWoodenTools)
		{		
			int removed = 0;
			if(CraftingManager.getInstance().getRecipeList().isEmpty()) return;
			Iterator<IRecipe> recipes = CraftingManager.getInstance().getRecipeList().iterator();	          
			while (recipes.hasNext()) {
				IRecipe currentRecipe = recipes.next();
				ItemStack result = currentRecipe.getRecipeOutput();
				if(result != null)
				{
					if(isRecipe(result, Items.WOODEN_AXE) || isRecipe(result, Items.WOODEN_HOE) || isRecipe(result, Items.WOODEN_PICKAXE) || isRecipe(result, Items.WOODEN_SHOVEL) || isRecipe(result, Items.WOODEN_SWORD)) {
						
						removed++;
						SysUtils.println("Removed recipe for " + result.getDisplayName());
						recipes.remove();
						
					}
				}			
			}
			 SysUtils.println("Removed " + removed + " recipes in total.");
		}
		
	}
	
	private static boolean isRecipe(ItemStack result, Item toTest)
	{
		return  result.isItemEqual(new ItemStack(toTest, 1));
	}

	
	
}
