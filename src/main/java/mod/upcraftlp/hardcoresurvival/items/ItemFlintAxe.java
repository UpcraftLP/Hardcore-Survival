package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import com.google.common.collect.Sets;

import mod.upcraftlp.hardcoresurvival.util.templates.BasicTool;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintAxe extends BasicTool {

	public ItemFlintAxe() {
		super("flint_axe", 6.0f, -3.2f, ToolMaterial.WOOD);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.TOOL_CLASSES = Sets.newHashSet(new String[] {"axe"});
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean p_77624_4_) {
		tooltip.add("Survivalist's Axe!");
		super.addInformation(itemStack, player, tooltip, p_77624_4_);
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }

}
