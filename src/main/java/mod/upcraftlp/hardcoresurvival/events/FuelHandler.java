package mod.upcraftlp.hardcoresurvival.events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

//TODO: merge into core
public class FuelHandler implements IFuelHandler {

	private static Map<ItemStack, Integer> burnTimes = new HashMap<ItemStack, Integer>();
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		Iterator<Entry<ItemStack, Integer>> i = burnTimes.entrySet().iterator();
		while(i.hasNext()) {
			Entry<ItemStack, Integer> e = i.next();
			ItemStack stack = e.getKey();
			if(ItemStack.areItemsEqual(stack, fuel))  {
				return e.getValue();
			}
		}
		return 0;
	}
	
	private static boolean register(ItemStack fuel, int burnTime) {
		ItemStack fuelStack =fuel.copy();
		fuelStack.setCount(1);
		Iterator<Entry<ItemStack, Integer>> i = burnTimes.entrySet().iterator();
		while(i.hasNext()) {
			Entry<ItemStack, Integer> e = i.next();
			ItemStack stack = e.getKey();
			if(ItemStack.areItemsEqual(stack, fuel))  {
				return false;
			}
		}
		burnTimes.put(fuel, burnTime);
		return true;
	}
	
	public static void registerFuel(ItemStack fuel, int burnTime) {
		if(!register(fuel, burnTime)) {
			//TODO: error message
		}
	}
	
	public static void registerFuel(Item fuel, int burnTime) {
		registerFuel(new ItemStack(fuel), burnTime);
	}

}
