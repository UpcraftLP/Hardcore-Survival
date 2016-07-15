package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemFlintPickaxe extends ItemPickaxe {

	public ItemFlintPickaxe() {
		super(ToolMaterial.WOOD);
		this.setFull3D();
		this.setUnlocalizedName("flint_pickaxe");
		this.setRegistryName("flint_pickaxe");
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Pickaxe!");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
