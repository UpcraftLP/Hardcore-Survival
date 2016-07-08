package mod.upcraftlp.betterleaves.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemFlintAxe extends ItemTool {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
	
	public ItemFlintAxe() {
		super(ToolMaterial.WOOD, EFFECTIVE_ON);
		this.setFull3D();
		this.setUnlocalizedName("flint_axe");
		this.setRegistryName("flint_axe");
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.damageVsEntity = 6.0f;
		this.attackSpeed = -3.2f;
		
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
