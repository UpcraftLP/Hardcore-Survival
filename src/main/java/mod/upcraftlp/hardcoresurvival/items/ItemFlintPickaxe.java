package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import core.upcraftlp.craftdev.API.templates.ItemTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintPickaxe extends ItemTool {

	public ItemFlintPickaxe() {
		super("flint_pickaxe", 1.0f, -2.8f, ToolMaterial.WOOD);
		this.setHarvestLevel("pickaxe", 0);
	}
		
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add("Survivalist's Pickaxe!");
		super.addInformation(itemStack, player, tooltip, advanced);
	}

}
