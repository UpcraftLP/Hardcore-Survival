package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import core.upcraftlp.craftdev.API.templates.ItemTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintShovel extends ItemTool {

	public ItemFlintShovel() {
		super("flint_shovel", 1.5f, -3.0f, ToolMaterial.WOOD);
		this.setHarvestLevel("shovel", 0);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add("Survivalist's Shovel!");
		super.addInformation(itemStack, player, tooltip, advanced);
	}

}
