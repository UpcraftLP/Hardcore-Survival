package mod.upcraftlp.hardcoresurvival.util.templates;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BasicArmor extends ItemArmor  {

	private String prefixedName;
	
	public BasicArmor(String name, String prefix, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.prefixedName = prefix + "_" + name;
		this.setRegistryName(this.prefixedName);
		this.setUnlocalizedName(this.prefixedName);
		this.setMaxStackSize(1);
	}

}
