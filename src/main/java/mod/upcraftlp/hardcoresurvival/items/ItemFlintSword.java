package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import core.upcraftlp.craftdev.API.templates.ItemSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintSword extends ItemSword {

	public ItemFlintSword() {
		super("flint_sword", ToolMaterial.WOOD);
		this.setFull3D();
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setHarvestLevel("sword", 0);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add("Survivalist's Sword!");
		tooltip.add("sharpened on the edges");
		super.addInformation(itemStack, player, tooltip, advanced);
	}

}
