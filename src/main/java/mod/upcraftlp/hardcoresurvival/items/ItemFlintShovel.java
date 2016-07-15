package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemFlintShovel extends ItemSpade {

	public ItemFlintShovel() {
		super(ToolMaterial.WOOD);
		this.setFull3D();
		this.setUnlocalizedName("flint_shovel");
		this.setRegistryName("flint_shovel");
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Shovel!");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
