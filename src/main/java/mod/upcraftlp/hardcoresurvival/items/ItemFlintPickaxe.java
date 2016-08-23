package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemFlintPickaxe extends ItemPickaxe {

	private final Set<String> TOOL_CLASSES = Sets.newHashSet(new String[] {"pickaxe"});
	
	
	public ItemFlintPickaxe() {
		super(ToolMaterial.WOOD);
		this.setFull3D();
		this.setUnlocalizedName("flint_pickaxe");
		this.setRegistryName("flint_pickaxe");
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return this.TOOL_CLASSES;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Pickaxe!");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

}
