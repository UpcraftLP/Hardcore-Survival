package mod.upcraftlp.hardcoresurvival.items;

import mod.upcraftlp.hardcoresurvival.util.templates.BasicFood;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class ItemAcorn extends BasicFood {

	public ItemAcorn() {
		super("acorn", 1, 0.7f, false);
		this.setAlwaysEdible();
		this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 10, 2), 0.35f);
	}
}
