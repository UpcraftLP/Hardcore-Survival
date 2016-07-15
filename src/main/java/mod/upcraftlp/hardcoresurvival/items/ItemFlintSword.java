package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemFlintSword extends ItemSword {

	public ItemFlintSword() {
		super(ToolMaterial.WOOD);
		this.setFull3D();
		this.setUnlocalizedName("flint_sword");
		this.setRegistryName("flint_sword");
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Sword!");
		tooltip.add("sharpened on the edges");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
