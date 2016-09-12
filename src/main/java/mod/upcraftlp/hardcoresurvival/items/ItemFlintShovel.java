package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import com.google.common.collect.Sets;

import mod.upcraftlp.hardcoresurvival.util.templates.BasicTool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintShovel extends BasicTool {

	public ItemFlintShovel() {
		super("flint_shovel", 1.5f, -3.0f, ToolMaterial.WOOD);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.TOOL_CLASSES = Sets.newHashSet(new String[] {"shovel"});
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Shovel!");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
