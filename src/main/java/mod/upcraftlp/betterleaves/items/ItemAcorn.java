package mod.upcraftlp.betterleaves.items;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class ItemAcorn extends ItemFood {

	public ItemAcorn() {
		super(1, 0.7f, false);
		this.setUnlocalizedName("acorn");
		this.setRegistryName("acorn");
		this.setAlwaysEdible();
		this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 10, 2), 0.35f);
	}
}
