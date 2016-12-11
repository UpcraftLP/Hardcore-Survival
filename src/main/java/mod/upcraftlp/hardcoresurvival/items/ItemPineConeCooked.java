package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import core.upcraftlp.craftdev.API.templates.ItemFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemPineConeCooked extends ItemFood {

	public ItemPineConeCooked() {
		super("cooked_pine_cone", 3, 0.3f, false);
		this.setMaxDamage(0);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add("Tasty!");
	}
	
	

}
