package mod.upcraftlp.hardcoresurvival.items;

import core.upcraftlp.craftdev.API.templates.ItemFood;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class ItemPineCone extends ItemFood {

	public ItemPineCone() {
		super("pine_cone", 1, 0.1f, false);
		this.setMaxDamage(0);
		this.setPotionEffect(new PotionEffect(MobEffects.HUNGER, 60 * 10), 0.5f);
	}
	
}
