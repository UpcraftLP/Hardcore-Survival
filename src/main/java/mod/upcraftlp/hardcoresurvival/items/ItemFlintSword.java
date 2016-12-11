package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemFlintSword extends ItemSword {

	private final Set<String> TOOL_CLASSES = Sets.newHashSet(new String[] {"axe"});
	
	public ItemFlintSword() {
		super(ToolMaterial.WOOD);
		this.setFull3D();
		this.setUnlocalizedName("flint_sword");
		this.setRegistryName("flint_sword");
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setHarvestLevel("sword", 0);
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return this.TOOL_CLASSES;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Sword!");
		tooltip.add("sharpened on the edges");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
