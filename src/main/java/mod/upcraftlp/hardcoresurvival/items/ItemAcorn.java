package mod.upcraftlp.hardcoresurvival.items;

import core.upcraftlp.craftdev.API.templates.ItemFood;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class ItemAcorn extends ItemFood {

	public ItemAcorn() {
		super("acorn", 1, 0.7f, false);
		this.setAlwaysEdible();
		this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 10, 2), 0.35f);
	}
}
