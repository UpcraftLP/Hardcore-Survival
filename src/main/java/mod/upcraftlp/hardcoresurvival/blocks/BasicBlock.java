package mod.upcraftlp.hardcoresurvival.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {

	public BasicBlock(String name) {
		this(Material.WOOD, name);
	}
	
	public BasicBlock(Material material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setDefaultState(this.getDefaultState());
		this.setHardness(0.7f);
		this.setResistance(1.5f);
		this.setLightLevel(15.0f);
		this.setHarvestLevel("axe", 1);
	}

}
