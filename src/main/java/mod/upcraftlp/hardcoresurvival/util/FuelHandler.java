package mod.upcraftlp.hardcoresurvival.util;

import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		
		//single Item cooked = 200 ticks
		if(item == HardcoreItems.BRANCH) return 120;
		if(item == HardcoreItems.PINE_CONE) return 80;
		return 0;
	}

}
