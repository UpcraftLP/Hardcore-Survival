package mod.upcraftlp.hardcoresurvival.util;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	private static HashMap<Item, Integer> burnTimes = new HashMap<Item, Integer>();
	
	public static boolean add(Item item, int time) {
		if(!burnTimes.containsKey(item)) {
			burnTimes.put(item, time);
			return true;
		}
		return false;
	}
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		if(burnTimes.containsKey(item)) return burnTimes.get(item);
		return 0;
	}

}
