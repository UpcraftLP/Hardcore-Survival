package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import core.upcraftlp.craftdev.API.templates.ItemTool;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlintAxe extends ItemTool {

	public ItemFlintAxe() {
		super("flint_axe", 6.0f, -3.2f, ToolMaterial.WOOD);
		this.setHarvestLevel("axe", 0);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add("Survivalist's Axe!");
		super.addInformation(itemStack, player, tooltip, advanced);
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }

}
