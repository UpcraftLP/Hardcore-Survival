package mod.upcraftlp.hardcoresurvival.util.templates;

import net.minecraft.item.ItemFood;

public class BasicFood extends ItemFood {

	public BasicFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
}
