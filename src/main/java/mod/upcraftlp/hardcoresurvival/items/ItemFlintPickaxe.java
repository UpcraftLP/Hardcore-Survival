package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import com.google.common.collect.Sets;

import mod.upcraftlp.hardcoresurvival.util.templates.BasicTool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintPickaxe extends BasicTool {

	public ItemFlintPickaxe() {
		super("flint_pickaxe", 1.0f, -2.8f, ToolMaterial.WOOD);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.TOOL_CLASSES = Sets.newHashSet(new String[] {"pickaxe"});
		this.setHarvestLevel("pickaxe", 0);
	}
		
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Pickaxe!");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
