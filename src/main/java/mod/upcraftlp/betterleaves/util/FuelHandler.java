package mod.upcraftlp.betterleaves.util;

import mod.upcraftlp.betterleaves.init.LeafItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		
		//single Item cooked = 200 ticks
		if(item == LeafItems.BRANCH) return 120;
		if(item == LeafItems.PINE_CONE) return 80;
		return 0;
	}

}
